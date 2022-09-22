package JavaAdvance.DefiningClassesExercise.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(" ");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCost = Double.parseDouble(data[2]);

            Car car = new Car(model,fuelAmount,fuelCost);
            cars.put(model,car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String [] data = input.split(" ");
            String model = data[1];
            int km = Integer.parseInt(data[2]);

            Car currentCar = cars.get(model);
            if (!currentCar.hasEnoughFuel(km)){
                System.out.println("Insufficient fuel for the drive");
            }else {
                currentCar.drive(km);
            }

            input = scanner.nextLine();
        }

        cars.values().stream().forEach(System.out::println);
    }
}
