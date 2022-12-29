package PolyMorphismExercises.P01Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));

        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        Map<String, Vehicle> map = new HashMap<>();
        map.put("Car", car);
        map.put("Truck", truck);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] parts = scanner.nextLine().split("\\s+");
            double quantity = Double.parseDouble(parts[2]);
            String type = parts[1];
            Vehicle currentVehicle = map.get(type);

            if ("Drive".equals(parts[0])){
                System.out.println(currentVehicle.drive(quantity));
            } else if ("Refuel".equals(parts[0])){
                currentVehicle.refuel(quantity);
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
