package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(data[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (data[1].equals("even")){
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();

                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    if (data[1].equals("<")) {
                        int number = Integer.parseInt(data[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) < number){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }else if (data[1].equals(">")){
                        int number = Integer.parseInt(data[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) > number){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();

                    }else if (data[1].equals(">=")){
                        int number = Integer.parseInt(data[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) >= number){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }else if (data[1].equals("<=")){
                        int number = Integer.parseInt(data[2]);
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) <= number){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
