package JavaAdvance.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> index = list -> {
            int min = Integer.MAX_VALUE;
            int numIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if (min >= list.get(i)){
                    min = list.get(i);
                    numIndex = i;
                }
            }
            return numIndex;
        };
        System.out.println(index.apply(numbers));
    }
}
