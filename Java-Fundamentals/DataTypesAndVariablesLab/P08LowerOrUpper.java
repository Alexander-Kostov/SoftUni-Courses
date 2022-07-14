package DataTypesAndVariablesLab;

import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);

        if (input == Character.toLowerCase(input)){
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }
    }
}
