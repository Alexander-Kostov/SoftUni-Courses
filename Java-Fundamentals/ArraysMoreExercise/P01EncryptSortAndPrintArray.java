package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int [] arr = new int[number];

        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            int sum = 0;

            for (int j = 0; j < name.length(); j++) {
            char letter = name.charAt(j);
            switch (letter){
                case 'a': case 'e': case 'i': case 'o': case 'u':
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    sum += letter * name.length();
                    break;
                default:
                    sum += letter / name.length();
                    break;
            }

            }
            arr [i] = sum;
        }

        Arrays.sort(arr);

        for (int num : arr) {
            System.out.println(num);

        }
    }
}
