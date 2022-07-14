package MidExam;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCities = Integer.parseInt(scanner.nextLine());

        int count = 0;

        double totalProfit = 0;


        for (int i = 0; i < numberOfCities; i++) {
            count++;
            String cityName = scanner.nextLine();
            double ownersIncome = Double.parseDouble(scanner.nextLine());
            double ownerExpenses = Double.parseDouble(scanner.nextLine());

            boolean isRainyCity = false;

            if (count % 5 == 0) {
                ownersIncome = ownersIncome * 0.90;
                isRainyCity = true;
            }
            if (!isRainyCity) {
                if (count % 3 == 0) {
                    ownerExpenses = (ownerExpenses * 0.50) + ownerExpenses;
                }
            }


            double finalResult = ownersIncome - ownerExpenses;
            totalProfit += finalResult;

            System.out.printf("In %s Burger Bus earned %.2f leva.\n", cityName, finalResult);
        }


        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
