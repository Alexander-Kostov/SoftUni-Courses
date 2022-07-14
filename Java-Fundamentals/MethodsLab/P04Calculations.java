package MethodsLab;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        int output;

        subtract(command, n1, n2);

        divide(command, n1, n2);

        addingNum(command, n1, n2);

        multiplyNum(command, n1, n2);

    }

    private static void multiplyNum(String command, int n1, int n2) {
        int output;
        if (command.equals("multiply")){
            output = n1 * n2;
            System.out.println(output);
        }
    }

    private static void addingNum(String command, int n1, int n2) {
        int output;
        if (command.equals("add")){
        output = n1 + n2;
            System.out.println(output);
        }
    }

    private static void divide(String command, int n1, int n2) {
        int output;
        if (command.equals("divide")){
            output = n1 / n2;
            System.out.println(output);
        }
    }

    private static void subtract(String command, int n1, int n2) {
        int output;
        if(command.equals("subtract")){
            output = n1 - n2;
            System.out.println(output);
        }
    }


}
