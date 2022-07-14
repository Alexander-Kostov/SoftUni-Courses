package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (symbol){
            case '*':
                System.out.println(Math.round(multiplyNumbers(firstNum,secondNum)));
                break;
            case '/':
                System.out.println(Math.round(divideNumbers(firstNum,secondNum)));
                break;
            case '+':
                System.out.println(Math.round(addNumbers(firstNum,secondNum)));
                break;
            case '-':
                System.out.println(Math.round(subtractNumbers(firstNum,secondNum)));
                break;
        }
    }

    private static double subtractNumbers(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    private static double addNumbers(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    private static double divideNumbers(double firstNum, int secondNum) {
        return firstNum / secondNum;
    }

    private static double multiplyNumbers(double firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}
