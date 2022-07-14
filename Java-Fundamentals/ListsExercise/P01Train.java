package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] data = input.split(" ");
            String command = data[0];

            if (command.equals("Add")){
                int passengers = Integer.parseInt(data[1]);
                wagons.add(passengers);

            } else {
                int number = Integer.parseInt(command);
                for (int i = 0; i < wagons.size(); i++) {
                    if (number + wagons.get(i) <= maxCapacity){
                        wagons.set(i,number + wagons.get(i));
                        break;
                    }
                }

            }
            input = scanner.nextLine();
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
