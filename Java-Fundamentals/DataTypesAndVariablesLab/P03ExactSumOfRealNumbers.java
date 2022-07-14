package DataTypesAndVariablesLab;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal number = BigDecimal.valueOf(0);

        for (int i = 0; i < n; i++) {
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());
            number = number.add(currentNum);

        }

        System.out.println(number);





    }
}
