package JavaAdvance.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isDivisible = num -> {
            for (Integer integer : numbers) {
                if (num % integer != 0){
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= number; i++) {
            if (isDivisible.test(i)){
                System.out.print(i + " ");
            }
        }
    }
}
