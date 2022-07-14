package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P06VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicleList = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")){
            String [] data = line.split(" ");
            Vehicle vehicle = new Vehicle(data[0],data[1],data[2],Double.parseDouble(data[3]));
            vehicleList.add(vehicle);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!line.equals("Close the Catalogue")){
            String model = line;

            vehicleList.stream().filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));

            line = scanner.nextLine();
        }

        List<Vehicle> cars = vehicleList.stream().filter(vehicle -> vehicle.getType().equals("car")).collect(Collectors.toList());
        List<Vehicle> trucks = vehicleList.stream().filter(vehicle -> vehicle.getType().equals("truck")).collect(Collectors.toList());

        double avHpCars = avgHp(cars);
        double avHpTrucks = avgHp(trucks);

        System.out.printf("Cars have average horsepower of: %.2f.\n",avHpCars);
        System.out.printf("Trucks have average horsepower of: %.2f.",avHpTrucks);

    }

    static double avgHp(List<Vehicle>vehicles){
        if (vehicles.size() == 0){
            return 0;
        }
        return vehicles.stream().mapToDouble(Vehicle::getHorsePower).sum() / vehicles.size();
    }

    static class Vehicle {
        String type;
        String model;
        String colour;
        double horsePower;

        Vehicle(String type, String model, String colour, double horsePower){
            this.type = type;
            this.model = model;
            this.colour = colour;
            this.horsePower = horsePower;
        }

        public double getHorsePower() {
            return horsePower;
        }

        public String getType(){
            return type;
        }

        public String getModel(){
            return model;
        }


        @Override
        public String toString() {
            return String.format("Type: %s\n" +
                    "Model: %s\n" +
                    "Color: %s\n" +
                    "Horsepower: %.0f",getType().toUpperCase().charAt(0) + getType().substring(1),this.model,this.colour,this.horsePower);
        }
    }
}
