package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String firstInput = scanner.nextLine();

        while (!firstInput.equals("PARTY")){
            guests.add(firstInput);

            firstInput = scanner.nextLine();
        }

        String comingGuests = scanner.nextLine();

        while (!comingGuests.equals("END")){
            guests.remove(comingGuests);


            comingGuests = scanner.nextLine();
        }

        System.out.println(guests.size());
        System.out.println(String.join(System.lineSeparator(),guests));
    }
}
