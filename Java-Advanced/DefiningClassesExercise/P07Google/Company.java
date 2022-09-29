package JavaAdvance.DefiningClassesExercise.P07Google;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company (String name, String department, double salary){
        this.companyName = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",companyName,department,salary);
    }
}
