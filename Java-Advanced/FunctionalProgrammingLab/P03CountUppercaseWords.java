package JavaAdvance.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUppercase = w -> Character.isUpperCase(w.charAt(0));
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).
                filter(startsWithUppercase).collect(Collectors.toList());

        System.out.println(words.size());

        Consumer<String> printWords = System.out::println;

        words.forEach(printWords);

//        System.out.println(String.join(System.lineSeparator(),words));
    }
}
