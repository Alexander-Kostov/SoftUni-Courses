package ArraysExcercise;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [] wagons = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int currentPeopleInWagon = Integer.parseInt(scanner.nextLine());
            wagons[i] = currentPeopleInWagon;
            sum += currentPeopleInWagon;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(wagons[i] + " ");
        }
        System.out.printf("\n%d",sum);

    }
}
