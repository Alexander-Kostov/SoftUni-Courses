package ArraysLab;

import java.util.Scanner;

public class P04ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String [] inputWithSpace = input.split(" ");


        for (int i = inputWithSpace.length - 1; i >= 0 ; i--) {
            System.out.print(inputWithSpace[i] + " ");
        }

    }
}
