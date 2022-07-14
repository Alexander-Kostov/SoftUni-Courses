package MethodsExercise;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestOfThreeNumbers(firstNum,secondNum,thirdNum));
    }

    private static int smallestOfThreeNumbers(int firstNum, int secondNum, int thirdNum) {
        int firstResult = Math.min(firstNum, secondNum);
        int lastResult = Math.min(firstResult, thirdNum);
        return lastResult;
    }
}
