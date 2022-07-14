package GenericsExercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")){
            String [] data = input.split(" ");
            String command = data[0];

            switch (command){
                case "Add":
                    String element = data[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(data[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = data[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);
                    customList.swap(firstIndex,secondIndex);
                    break;
                case "Greater":
                    element = data[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case"Print":
                    System.out.print(customList.toString());
                    break;
                default:
                    System.out.println("Invalid command");
            }

            input = scanner.nextLine();
        }
    }
}
