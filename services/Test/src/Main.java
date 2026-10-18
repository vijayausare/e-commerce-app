import java.util.*;

public class Main {
    
    public static void main(String args[]){
        List<Employee> employeList = new ArrayList<Employee>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> map1 = new HashSet<>();
        
        Employee e1 = new Employee("John Doe", 30);
        Employee e2 = new Employee("Vijay A", 24);
        Employee e3 = new Employee("Vijay A", 25);
        employeList.add(e1);
        employeList.add(e2);
        employeList.add(e3);
        
        List<String> nameList = employeList.stream().map(emp-> emp.getName()).toList();

        nameList.forEach(name -> System.out.println(name));

        String name = "Vijay";
        name.toUpperCase();
        name.replace('J', 'N');
        System.out.println(name); // VINAY

        int i  = 1;
        int j = 2;

        i = i+j; // 3
        j = i-j; // 3-2
        i = i-j; // 3-1


        
    }

    public int[] findTargetSum() {
        int[] arr = {1, 2, 3, 4, 5, 6,7 ,8, 9};
        // target = 5
        for (int aa = 0;aa<arr.length; aa++) {
            for (int bb = aa + 1; bb < arr.length; bb++) {
                if (arr[aa] + arr[bb] == 5) {
                    return new int[]{arr[aa], arr[bb]};
                }
            }
        }
        return new int[] {0, 0};
    }
}