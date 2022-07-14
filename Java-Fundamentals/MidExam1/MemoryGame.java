package MidExam1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String line = scanner.nextLine();
        int moves = 0;
        while (!line.equals("end")) {
            String[] data = line.split(" ");
            int firstIndex = Integer.parseInt(data[0]);
            int secondIndex = Integer.parseInt(data[1]);
            boolean validFirstIndex = validationOfIndex(firstIndex, sequence.size());
            boolean validSecondIndex = validationOfIndex(secondIndex, sequence.size());
            moves++;

            if (validFirstIndex && validSecondIndex && firstIndex != secondIndex) {
                if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!\n",sequence.get(firstIndex));
                    String object = sequence.get(firstIndex);
                    sequence.remove(object);
                    sequence.remove(object);

                } else {
                    System.out.println("Try again!");
                }

            } else {
                //cheten i necheten list
                int splittingIndex = sequence.size() / 2;
                String element = String.format("-%da", moves);
                sequence.add(splittingIndex, element);
                sequence.add(splittingIndex, element);
                System.out.println("Invalid input! Adding additional elements to the board");
            }

            if (sequence.size() == 0){
                System.out.printf("You have won in %d turns!",moves);
                break;
            }

            line = scanner.nextLine();
        }

        if (sequence.size() != 0){
            System.out.println("Sorry you lose :(");
            for (String s : sequence) {
                System.out.printf("%s ",s);
            }
        }
    }

    private static boolean validationOfIndex(int firstIndex, int size) {
        return firstIndex >= 0 && firstIndex < size;
    }
}
