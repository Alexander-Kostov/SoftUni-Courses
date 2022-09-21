package JavaAdvance.DefiningClassesExercise.P02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departmentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            Employee employee = null;
            if (data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (data.length == 5) {
                if (data[4].contains("@")) {
                    String email = data[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(data[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else {
                employee = new Employee(name, salary, position, department);
            }
            boolean hasDepartment = departmentList.stream().filter(dep -> dep.getName().equals(department)).count() >= 1;
            if (!hasDepartment) {
                departmentList.add(new Department(department));
            }

            Department current = departmentList.stream().filter(dep -> dep.getName().equals(department)).findFirst().get();
            current.getEmployees().add(employee);

        }

        Department highestDepartment = departmentList.stream().max(Comparator.comparingDouble(dep -> dep.calculateAverage())).get();
        System.out.printf("Highest Average Salary: %s%n", highestDepartment.getName());

        highestDepartment.getEmployees().stream().sorted((p1, p2) ->
                Double.compare(p2.getSalary(), p1.getSalary())).forEach(System.out::println);
    }
}
