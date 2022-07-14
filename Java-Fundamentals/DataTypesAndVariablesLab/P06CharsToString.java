package DataTypesAndVariablesLab;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String finalWord = "";

        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();
            char name = input.charAt(0);
            finalWord += name;
        }

        System.out.println(finalWord);




    }
}
