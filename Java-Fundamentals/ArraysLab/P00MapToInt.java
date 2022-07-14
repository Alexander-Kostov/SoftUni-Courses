package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P00MapToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String inputLine = scanner.nextLine();
//
//        String[] items = inputLine.split(" ");
//
//        int [] arr = Arrays.stream(items).mapToInt(Integer::parseInt).toArray();
        int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(arr[0] + arr [1]);

    }
}
