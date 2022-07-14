package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    int number = Integer.parseInt(data[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(data[1]);
                    int index = Integer.parseInt(data[2]);
                    if (index < 0 || index > numbers.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(index, number);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(data[1]);
                    if (index < 0 || index > numbers.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(index);
                    }
                    break;
                case "Shift":
                    if (data[1].equals("left")) {
                        int count = Integer.parseInt(data[2]);
                        for (int i = 0; i < count; i++) {
                            int temp = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(temp);
                        }
                    } else {
                        int count = Integer.parseInt(data[2]);
                        for (int i = 0; i < count; i++) {
                            int temp = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, temp);
                        }

                    }
                    break;
            }


            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
