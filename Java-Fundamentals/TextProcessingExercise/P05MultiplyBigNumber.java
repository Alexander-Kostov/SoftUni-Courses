package TextProcessingExercise;

import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        int reminder = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            int lastNum = Integer.parseInt(String.valueOf(number.charAt(i)));
            int product = lastNum * multiplier + reminder;

            if (i == 0){
                sb.insert(0, product);
            } else {
                int digit = product % 10;
                sb.insert(0,digit);
                reminder = product / 10;
            }
        }

        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        System.out.println(sb);
    }
}
