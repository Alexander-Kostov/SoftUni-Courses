package MethodsExercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());


        int finalResult = sumOfFirstTwoIntegers(firstNum,secondNum) - subtractingTheFirstMethod(thirdNum);
        System.out.println(finalResult);
    }

    private static int subtractingTheFirstMethod(int thirdNum) {
        return thirdNum;
    }


    private static int sumOfFirstTwoIntegers(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
