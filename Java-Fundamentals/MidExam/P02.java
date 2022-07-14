package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("Finish")) {
            String[] data = line.split(" ");

            String command = data[0];

            switch (command) {
                case "Add":
                    integerList.add(Integer.parseInt(data[1]));
                    break;
                case "Remove":
                    integerList.remove(Integer.valueOf(Integer.parseInt(data[1])));
                    break;
                case "Replace":

                    break;
                case "Collapse":
                    break;

            }

            line = scanner.nextLine();

        }

        for (int item : integerList) {
            System.out.print(item + " ");
        }


    }
}
