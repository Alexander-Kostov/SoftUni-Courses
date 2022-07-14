package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("#.####").format(MathPower(number,power)));
    }

    private static double MathPower (double number, int power){
        return Math.pow(number,power);
    }
}
