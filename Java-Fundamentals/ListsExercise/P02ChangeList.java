package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] data = input.split(" ");

            int number = Integer.parseInt(data[1]);
            if (data[0].equals("Delete")){
                for (int i = 0; i < numbers.size(); i++) {
                    if (number == numbers.get(i)){
                        numbers.remove(numbers.get(i));
                    }
                }
            }else {
                int index = Integer.parseInt(data[2]);
                numbers.add(index,number);

            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
