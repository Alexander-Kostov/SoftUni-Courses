package TextProcessingLab;

import java.util.Scanner;

public class P05DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder numbers = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();


        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                numbers.append(symbol);
            } else if (symbol >= 65 && symbol <= 90 || (symbol >= 97 && symbol <= 122)) {
                letters.append(symbol);
            } else {
                other.append(symbol);
            }
        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(other);
    }
}
