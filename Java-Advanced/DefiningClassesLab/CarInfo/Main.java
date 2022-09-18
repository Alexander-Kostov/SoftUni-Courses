package JavaAdvance.DefiningClassesLab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String brand = carInfo[0];
            String model = carInfo[1];
            int horsePower = Integer.parseInt(carInfo[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
