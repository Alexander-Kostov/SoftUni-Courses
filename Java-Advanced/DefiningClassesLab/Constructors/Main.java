package JavaAdvance.DefiningClassesLab.Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String input = scanner.nextLine();

            String [] data = input.split(" ");
            Car car;
            String brand = data[0];
            if (data.length == 1) {
            car = new Car(brand);
            }else {
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);
            car = new Car(brand,model,horsePower);
            }

            System.out.println(car.carInfo());
        }
    }
}
