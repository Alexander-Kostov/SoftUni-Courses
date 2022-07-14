package MethodsLab;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        if (command.equals("int")){
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        System.out.println(getMaxInt(first,second));

        } else if (command.equals("char")){
            char first = scanner.nextLine().charAt(0);
            char second = scanner.nextLine().charAt(0);

            System.out.println(getMaxChar(first,second));

        }else if (command.equals("string")){
            String first = scanner.nextLine();
            String second = scanner.nextLine();

            System.out.println(getMaxString(first,second));
        }



    }

    private static String getMaxString(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }

    private static char getMaxChar(char first, char second) {
        return (char) Math.max(first,second);
    }

    private static int getMaxInt(int firstNum, int secondNum) {

        if (firstNum > secondNum) {
            return firstNum;
        }
        return secondNum;
    }

}
