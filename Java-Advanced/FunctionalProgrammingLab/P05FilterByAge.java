package JavaAdvance.FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05FilterByAge {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person p = new Person(name, age);
            people.add(p);


        }

        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = filterPeople(people, getPredicate(ageCondition, condition));
        Consumer<Person> printer = getPrinter(format);

        people.forEach(printer);
    }

    private static Consumer<Person> getPrinter(String format) {
        switch (format){
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default: throw new IllegalArgumentException("Invalid format");
        }
    }

    private static Predicate<Person> getPredicate(int ageCondition, String condition) {
        switch (condition) {
            case "younger":
                return p -> p.age <= ageCondition;
            case "older":
                return p -> p.age >= ageCondition;
            default:
                throw new IllegalArgumentException("Invalid parameters");
        }
    }

    public static List<Person> filterPeople(List<Person> people, Predicate<Person> predicate) {

        return people.stream().filter(predicate).collect(Collectors.toList());
    }
}
