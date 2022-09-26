package JavaAdvance.DefiningClassesExercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        Map<String,Engine> engineMap = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfEngines; i++) {
            String [] data = scanner.nextLine().split(" ");
            String model = data[0];
            int power = Integer.parseInt(data[1]);
            Engine engine = null;
            if (data.length == 2){
                engine = new Engine(model,power);
            }else if (data.length == 3){
                try {
                    int displacement = Integer.parseInt(data[2]);
                    engine = new Engine(model,power,displacement);
                } catch (NumberFormatException e){
                    String efficiency = data[2];
                    engine = new Engine(model,power,efficiency);
                }
            }else if (data.length == 4){
                int displacement = Integer.parseInt(data[2]);
                String efficiency = data[3];
                engine = new Engine(model,power,displacement,efficiency);
            }
            engineMap.put(model,engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String [] data = scanner.nextLine().split(" ");

            String carModel = data[0];
            String engineModel = data[1];
            Engine engine = engineMap.get(engineModel);
            Car car = null;
            if (data.length == 2){
            car = new Car(carModel,engine);
            }else if (data.length == 3){
                try {
                    int weight = Integer.parseInt(data[2]);
                    car = new Car(carModel,engine,weight);
                }catch (NumberFormatException e){
                    String color = data[2];
                    car = new Car(carModel,engine,color);
                }
            }else if (data.length == 4){
                int weight = Integer.parseInt(data[2]);
                String color = data[3];
                car = new Car(carModel,engine,weight,color);
            }
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
