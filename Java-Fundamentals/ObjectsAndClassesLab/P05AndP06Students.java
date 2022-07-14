package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05AndP06Students {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public String getHometown() {
            return hometown;
        }

        Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        String getStudentInfo() {
            return firstName + " " + lastName + " is " + age + " years old";
        }

        String getFirstName() {
            return this.firstName;
        }

        String getLastName() {
            return this.lastName;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {
            String[] data = input.split(" ");

            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];

            int index = indexOfStudents(students, firstName, lastName);

            if (index == -1) {
                students.add(new Student(firstName, lastName, age, hometown));
            } else {
                students.set(index,new Student(firstName,lastName,age,hometown));
            }


            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        for (Student student : students) {
            if (secondInput.equals(student.getHometown())) {
                System.out.println(student.getStudentInfo());
            }
        }
    }

    private static int indexOfStudents(List<Student> students, String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }
}
