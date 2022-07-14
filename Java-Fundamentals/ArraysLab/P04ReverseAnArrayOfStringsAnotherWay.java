package ArraysLab;

import java.util.Scanner;

public class P04ReverseAnArrayOfStringsAnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] stringArray =  input.split("\\s+");

        for (int i = 0; i < stringArray.length / 2; i++) {
            int otherIndex = stringArray.length - 1 - i;

            String lastValue = stringArray[otherIndex];
            String firstValue = stringArray[i]; // a
            stringArray[i] = lastValue;
            stringArray[otherIndex] = firstValue;

            // A B C D E//
            //temporary -  A
            //secondValue - E
            //stringArray[i] = secondValue; E -> i
            //temporary -> secondvalue

        }

        for (String s : stringArray ) {
            System.out.print(s + " ");
        }


    }
}
