package JavaAdvance.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

       Function<int[], Integer> function = ints -> {
           int min = Integer.MAX_VALUE;

           for (int number : numbers) {
               if (min > number){
                   min = number;
               }
           }
           return min;
       };

//       Function <int[], Integer> func = ints -> Arrays.stream(ints).min().getAsInt();

        System.out.println(function.apply(numbers));

    }
}
