package MidExam;

import java.util.Scanner;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String items = scanner.nextLine();
        String[] itemArr = items.split(", ");
        int[] arr = new int[itemArr.length];

        for (int i = 0; i < itemArr.length; i++) {
            arr[i] = Integer.parseInt(itemArr[i]);
        }
        int entry = Integer.parseInt(scanner.nextLine());
        String CheapOrExpensive = scanner.nextLine();
        int sum1 = 0;
        int sum2 = 0;

        if (CheapOrExpensive.equals("cheap")) {
            for (int i = 0; i < entry; i++) {
                if (arr[i] < arr[entry]) {
                    sum1 = sum1 + arr[i];
                }
            }
            for (int i = entry + 1; i < itemArr.length; i++) {
                if (arr[i] < arr[entry]) {
                    sum2 = sum2 + arr[i];
                }
            }
        }
        if (CheapOrExpensive.equals("expensive")) {
            for (int i = 0; i < entry; i++) {
                if (arr[i] >= arr[entry]) {
                    sum1 = sum1 + arr[i];
                }
            }
            for (int i = entry + 1; i < itemArr.length; i++) {
                if (arr[i] >= arr[entry]) {
                    sum2 = sum2 + arr[i];
                }
            }
        }
        if (sum1 >= sum2) {
            System.out.println("Left - " + sum1);
        } else {
            System.out.println("Right - " + sum2);
        }

    }
}
