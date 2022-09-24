package JavaAdvance.DefiningClassesExercise.P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(" ");
            String model = data[0];

            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Engine engine = new Engine(engineSpeed,enginePower);

            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight,cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < data.length; j = j + 2) {
                double tirePressure = Double.parseDouble(data[j]);
                int age = Integer.parseInt(data[j + 1]);
                Tire tire = new Tire(tirePressure,age);
                tires.add(tire);
            }

            Car car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")){
            cars.stream().filter(car -> car.getCargo().getType().equals("fragile")).
                    filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1)).
                    forEach(car -> System.out.println(car.getModel()));
        }else if (cargoType.equals("flamable")){
            cars.stream().filter(car -> car.getCargo().getType().equals("flamable")).
                    filter(car -> car.getEngine().getPower() > 250).forEach(car -> System.out.println(car.getModel()));
        }
    }
}
