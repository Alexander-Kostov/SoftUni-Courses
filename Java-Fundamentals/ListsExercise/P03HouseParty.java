package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> people = new ArrayList<>();

        for (int i = 0; i < numberOfCommands; i++) {

            String name = scanner.nextLine();

            String[] data = name.split(" ");

            if (data[2].equals("going!")) {
                if (i == 0) {
                    people.add(data[0]);
                }
                boolean isInTheList = false;
                for (int j = 0; j < people.size(); j++) {
                    if (i == 0){
                        break;
                    }
                    if (data[0].equals(people.get(j))) {
                        System.out.printf("%s is already in the list!\n", data[0]);
                        isInTheList = true;
                        break;
                    }
                }
                if (i != 0 && !isInTheList) {
                    people.add(data[0]);
                }
            } else {
                boolean gone = true;
                for (int j = 0; j < people.size(); j++) {
                    if (data[0].equals(people.get(j))) {
                        people.remove(data[0]);
                        gone = false;
                        break;
                    }
                }
                if (gone) {
                    System.out.printf("%s is not in the list!\n", data[0]);
                }

            }
        }

        for (String person : people) {
            System.out.println(person);
        }

    }
}
