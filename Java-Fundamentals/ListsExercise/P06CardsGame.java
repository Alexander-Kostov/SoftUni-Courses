package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());



        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
                firstPlayer.remove(firstPlayer.get(0));
                secondPlayer.remove(secondPlayer.get(0));
            } else if (secondPlayer.get(0) > firstPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(firstPlayer.get(0));
                secondPlayer.remove(secondPlayer.get(0));
                firstPlayer.remove(firstPlayer.get(0));
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }

        }
        int sum = 0;
        if (firstPlayer.size() != 0) {
            for (Integer card : firstPlayer) {
                sum += card;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (Integer card : secondPlayer) {
                sum += card;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
