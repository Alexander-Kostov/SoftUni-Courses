package JavaAdvance.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).
                map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, String> countFormat = s -> "Count = " + s.size();
        Function<List<Integer>, Integer> sum = l -> l.stream().mapToInt(e -> e).sum();
        Function<Integer,String> sumFormat = s -> "Sum = " + s;

        String outputCount = countFormat.apply(numbers);

        System.out.println(outputCount);

        int ssum = sum.apply(numbers);
        String outputSum = sumFormat.apply(ssum);

        System.out.println(outputSum);
    }
}
