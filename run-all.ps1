# Starts the infrastructure and all Spring services in order, each in its own window.
# Usage (from the repo root):  .\run-all.ps1
# If scripts are blocked:      powershell -ExecutionPolicy Bypass -File .\run-all.ps1

$root = $PSScriptRoot

function Wait-ForPort([int]$port, [string]$name, [int]$timeoutSec = 180) {
    Write-Host "Waiting for $name on port $port ..." -NoNewline
    $deadline = (Get-Date).AddSeconds($timeoutSec)
    while ((Get-Date) -lt $deadline) {
        if (Test-NetConnection -ComputerName localhost -Port $port -InformationLevel Quiet -WarningAction SilentlyContinue) {
            Write-Host " up"
            return
        }
        Start-Sleep -Seconds 3
    }
    Write-Host " timed out (continuing anyway)"
}

function Start-Service([string]$name) {
    Write-Host "Starting $name"
    Start-Process powershell -ArgumentList "-NoExit", "-Command", "`$host.UI.RawUI.WindowTitle='$name'; cd '$root\services\$name'; .\mvnw spring-boot:run"
}

Write-Host "Starting infrastructure only (Docker); services run from Maven"
Set-Location $root
docker compose up -d postgresql pgadmin zipkin mongodb mongo-express kafka mail-dev
if ($LASTEXITCODE -ne 0) { Write-Host "docker compose failed, is Docker Desktop running?"; exit 1 }
Wait-ForPort 5432 "PostgreSQL"
Wait-ForPort 9092 "Kafka"

# Create the databases if they are missing (the Postgres container only creates the default one)
foreach ($db in "product", "order", "payment") {
    $exists = docker exec ms_pg_sql psql -U vijay -tAc "SELECT 1 FROM pg_database WHERE datname='$db'"
    if ($exists -ne "1") {
        docker exec ms_pg_sql psql -U vijay -c "CREATE DATABASE `"$db`";" | Out-Null
        Write-Host "Created database $db"
    }
}

Start-Service "config-server"; Wait-ForPort 8888 "config-server"
Start-Service "discovery";     Wait-ForPort 8761 "discovery"

foreach ($s in "customer", "product", "order", "payment", "notification") { Start-Service $s }
Wait-ForPort 8090 "customer"
Wait-ForPort 8050 "product"
Wait-ForPort 8070 "order"
Wait-ForPort 8060 "payment"
Wait-ForPort 8040 "notification"

Start-Service "gateway"; Wait-ForPort 8222 "gateway"

Write-Host ""
Write-Host "All services are up."
Write-Host "Swagger UI: http://localhost:8222/swagger-ui.html"
Write-Host "Eureka:     http://localhost:8761"
Write-Host "To stop: close the service windows, then run 'docker compose down'."
