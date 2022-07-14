package RetakeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WeaponSmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> parts = Arrays.stream(scanner.nextLine().split("[|]")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Remove":
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < parts.size()) {
                        parts.remove(index);
                    }
                    break;
                case "Add":
                    //validirane na index
                    String particle = data[1];
                    index = Integer.parseInt(data[2]);
                    if (index >= 0 && index < parts.size()) {
                        parts.add(index, particle);
                    }
                    break;
                case "Check":
                    String check = data[1];
                    if (check.equals("Even")) {
                        for (int i = 0; i < parts.size(); i++) {
                            if (i % 2 == 0) {
                                System.out.printf("%s ", parts.get(i));
                            }
                        }
                        System.out.println();
                    } else if (check.equals("Odd")) {
                        for (int i = 0; i < parts.size(); i++) {
                            if (i % 2 != 0) {
                                System.out.printf("%s ", parts.get(i));
                            }
                        }
                        System.out.println();
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("You crafted %s!", String.join("", parts));
    }
}
