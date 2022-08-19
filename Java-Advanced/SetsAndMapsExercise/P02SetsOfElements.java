package JavaAdvance.SetsAndMapsExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        int first = data[0];
        int second = data[1];

        for (int i = 0; i < first; i++) {
            int firstNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(firstNumber);
        }

        for (int i = 0; i < second; i++) {
            int secondNumber = Integer.parseInt(scanner.nextLine());
            secondSet.add(secondNumber);
        }

        Set<Integer> lastSet = new LinkedHashSet<>();

        for (Integer integer : firstSet) {
            for (Integer integer2 : secondSet) {
                if (integer.equals(integer2)){
                    lastSet.add(integer);
                }
            }
        }

        for (Integer integer : lastSet) {
            System.out.print(integer + " ");
        }


    }
}
