package RetakeExam;

import java.util.Scanner;

public class GoogleSearches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyPerSearch = Double.parseDouble(scanner.nextLine());
        double totalMoney = 0;

        int numberOfSearches = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfSearches; i++) {
            int currentSearch = Integer.parseInt(scanner.nextLine());
            double currentSum = 0;

            if (i % 3 == 0){
                if (currentSearch <= 1){
                    continue;
                }else if (currentSearch > 5){
                    currentSum = (currentSearch * moneyPerSearch) * 2;
                    totalMoney += currentSum * 3;
                    continue;
                }else {
                    currentSum = currentSearch * moneyPerSearch;
                    totalMoney += currentSum * 3;
                    continue;
                }

            }

            if (currentSearch <= 1){
                continue;
            }else if (currentSearch > 5){
                currentSum = (currentSearch * moneyPerSearch) * 2;
                totalMoney += currentSum;
            }else {
                totalMoney += currentSearch * moneyPerSearch;
            }
        }

        System.out.printf("Total money earned: %.2f", totalMoney);
    }
}
