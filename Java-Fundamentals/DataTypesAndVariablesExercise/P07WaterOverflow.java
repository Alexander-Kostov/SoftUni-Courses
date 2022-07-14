package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tank = 0;

        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            if (liters + tank > 255){
                System.out.println("Insufficient capacity!");
                continue;
            }
            tank += liters;

        }
        System.out.println(tank);

    }
}
