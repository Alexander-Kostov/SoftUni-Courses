package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evenNumber = Integer.parseInt(scanner.nextLine());

        while (true){
            if (evenNumber % 2 == 0){
                System.out.printf("The number is: %d",Math.abs(evenNumber));
                break;
            } else {
                System.out.println("Please write an even number.");
            }
            evenNumber = Integer.parseInt(scanner.nextLine());
        }
    }
}
