package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name,age);

            personList.add(person);

        }

        for (Person person : personList) {
            if (person.getAge() > 30){
                System.out.println(person.getInfo());
            }
        }

    }

    static class Person {
        String name;
        int age;

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        String getInfo (){
           return String.format("%s - %d",this.name,this.age);
        }
    }
}
