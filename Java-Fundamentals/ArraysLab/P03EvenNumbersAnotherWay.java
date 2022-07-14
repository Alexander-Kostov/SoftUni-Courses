package ArraysLab;

import java.util.Scanner;

public class P03EvenNumbersAnotherWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String [] numbersAsString = input.split(" ");

        int sum = 0;

        for (String s : numbersAsString){
            int currentNum = Integer.parseInt(s);
            if (currentNum % 2 == 0){
                sum += currentNum;
            }
        }
        System.out.println(sum);
    }
}
