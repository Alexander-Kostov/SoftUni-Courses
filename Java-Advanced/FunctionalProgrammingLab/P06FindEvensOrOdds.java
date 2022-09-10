package JavaAdvance.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String condition = scanner.nextLine();

        int low = data[0];
        int up = data[1];

        System.out.println(IntStream.rangeClosed(low, up).boxed().filter(getPredicate(condition))
                .map(String::valueOf).collect(Collectors.joining(" ")));


    }

    public static Predicate<Integer> getPredicate(String condition) {
        if (condition.equals("odd")) {
            return p -> p % 2 != 0;
        }
        return p -> p % 2 == 0;


    }
}
