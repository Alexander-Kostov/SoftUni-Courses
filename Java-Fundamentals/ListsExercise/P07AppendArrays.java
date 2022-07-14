package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] array = input.split("\\|");

        List<String> finalArray = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            String[] currentArray = array[i].split("\\s+");
            for (int j = 0; j < currentArray.length; j++) {
                if (currentArray[j].equals("")) {
                    continue;
                }
                finalArray.add(currentArray[j]);

            }
        }

        for (String s : finalArray) {
            System.out.print(s + " ");
        }

    }
}
