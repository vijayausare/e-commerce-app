public class Employee implements IEmployee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
