package ListsLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0){
                numbers.remove(numbers.get(i));
                i--;
            }
        }
        Collections.reverse(numbers);

        if (numbers.size() == 0) {
            System.out.println("empty");
        } else {

            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
