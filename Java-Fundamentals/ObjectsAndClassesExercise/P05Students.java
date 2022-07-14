package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Student student = new Student(firstName,lastName,grade);

            studentList.add(student);
        }

        studentList.stream().sorted((p2, p1) -> Double.compare(p1.getGrade(),p2.getGrade())).
                forEach(student -> System.out.println(student.toString()));

    }

    static class Student {
        String firstName;
        String lastName;
        double grade;

        Student (String firstName, String lastName, double grade){
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        double getGrade (){
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f",this.firstName,this.lastName,this.grade);
        }
    }
}
