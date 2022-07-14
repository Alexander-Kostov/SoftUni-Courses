package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();

        while (!input.equals("End")){
            String [] data = input.split(" ");
            Student student = new Student(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            students.add(student);

            input = scanner.nextLine();
        }

        students.stream().sorted((p1,p2) -> Integer.compare(p1.getAge(),p2.getAge())).
                forEach(System.out::println);
    }
    static class Student{
        String name;
        int id;
        int age;

        Student(String name, int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }

        int getAge(){
            return this.age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %d is %d years old.",this.name,this.id,this.age);
        }
    }
}
