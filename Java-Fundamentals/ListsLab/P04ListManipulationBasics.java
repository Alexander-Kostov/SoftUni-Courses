package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();


        while (!line.equals("end")) {
            String[] data = line.split(" ");
            String command = data[0];
            switch (command){
                case "Add":
                    Integer number = Integer.parseInt(data[1]);
                    numbers.add(number);
                    break;
                case "Remove":
                    Integer removedNumber = Integer.parseInt(data[1]);
                    numbers.remove(removedNumber);
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(data[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    Integer insertingNumber = Integer.parseInt(data[1]);
                    int insertIndex = Integer.parseInt(data[2]);
                    numbers.add(insertIndex,insertingNumber);
                    break;
            }
            line = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
