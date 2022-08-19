package JavaAdvance.SetsAndMapsExercise;

import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String [] data = scanner.nextLine().split("\\s+");

            for (String datum : data) {
                elements.add(datum);
            }
        }

        System.out.println(String.join(" ",elements));
    }
}
