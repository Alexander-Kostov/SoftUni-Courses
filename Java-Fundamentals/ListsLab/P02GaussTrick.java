package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> finalList = new ArrayList<>();

        if (numbers.size() % 2 == 0) {
            for (int i = 0; i < numbers.size() / 2; i++) {
                int number = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
                finalList.add(number);
            }
        } else {
            for (int i = 0; i < numbers.size() / 2; i++) {
                int number = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
                finalList.add(number);
            }
            int finalNumber = numbers.get(numbers.size() / 2);
            finalList.add(finalNumber);
        }

        for (Integer number : finalList) {
            System.out.print(number + " ");
        }

    }
}
