package DataTypesAndVariablesLab;

import java.util.Scanner;

public class P01ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Meters = Integer.parseInt(scanner.nextLine());

        double metersInKm = Meters / 1000.0;

        System.out.printf("%.2f", metersInKm);

    }
}
