package P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")){
            String [] data = input.split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            Person person = new Person(name,age,town);
            personList.add(person);


            input = scanner.nextLine();
        }

        int indexToCompare = Integer.parseInt(scanner.nextLine());
        Person personToCompare = personList.get(indexToCompare - 1);
        
        int totalPeople = personList.size();
        int samePeople = 0;
        int diffPeople = 0;

        for (Person person : personList) {
            if (person.compareTo(personToCompare) == 0){
                samePeople++;
            }else {
                diffPeople++;
            }
        }

        if (samePeople == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", samePeople,diffPeople,totalPeople);
        }
        System.out.println();
        

    }
}
