package InterfacesAndAbstractionExercise.P03BirthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthSubjects = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputParts = input.split("\\s+");
            switch (inputParts[0]) {
                case "Citizen":
                    String citizenName = inputParts[1];
                    int age = Integer.parseInt(inputParts[2]);
                    String id = inputParts[3];
                    String citizenBirthDate = inputParts[4];
                    Citizen citizen = new Citizen(citizenName, age, id, citizenBirthDate);
                    birthSubjects.add(citizen);
                    break;
                case "Pet":
                    String name = inputParts[1];
                    String birthDate = inputParts[2];
                    Pet pet = new Pet(name, birthDate);
                    birthSubjects.add(pet);
                    break;
                case "Robot":

                    break;
            }


            input = scanner.nextLine();
        }

        String date = scanner.nextLine();

        birthSubjects.stream().map(Birthable::getBirthDate).filter(birth -> birth.endsWith(date)).forEach(System.out::println);
    }
}
