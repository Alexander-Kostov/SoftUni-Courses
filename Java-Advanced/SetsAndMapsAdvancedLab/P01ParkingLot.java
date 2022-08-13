package JavaAdvance.SetsAndMapsAdvancedLab;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            String[] data = line.split(", ");
            String direction = data[0];
            String car = data[1];

            if (direction.equals("IN")) {
                cars.add(car);
            } else if (direction.equals("OUT")) {
                cars.remove(car);
            }

            line = scanner.nextLine();
        }

        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            System.out.println(String.join(System.lineSeparator(),cars));
        }
    }
}
