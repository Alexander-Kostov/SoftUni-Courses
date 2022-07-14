package MethodsLab;

import java.util.Scanner;

public class P06CalculatingRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double result = printTriangleArea(width, height);
        System.out.printf("%.0f",result);

    }

    private static double printTriangleArea(double width, double height) {
        return width * height;
    }

}
