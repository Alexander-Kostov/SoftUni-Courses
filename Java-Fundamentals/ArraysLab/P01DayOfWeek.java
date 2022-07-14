package ArraysLab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] days = {"Monday","Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int number = scanner.nextInt();
        if (number >= 1 && number <= 7){
            System.out.println(days [number - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
