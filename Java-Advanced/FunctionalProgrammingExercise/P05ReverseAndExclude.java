package JavaAdvance.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> divisible = number -> number % n == 0;

        numbers.removeIf(divisible);
        Collections.reverse(numbers);

        numbers.forEach(number -> System.out.print(number + " "));
    }
}
