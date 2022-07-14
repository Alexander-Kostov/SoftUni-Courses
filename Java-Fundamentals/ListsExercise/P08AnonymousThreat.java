package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String line = scanner.nextLine();

        while (!line.equals("3:1")){
            String[] commands = line.split(" ");

            switch (commands[0]){
                case "merge":
                    List<String> result = new ArrayList<>();
                    int start = Math.max(0, Integer.parseInt(commands[1]));
                    int end = Math.min(Integer.parseInt(commands[2]), strings.size() - 1);
                    // add everything before merge to result List
                    if (start > 0 && start < strings.size()) {
                        // wrong
                        // result = strings.subList(0, start);
                        // correct
                        result.addAll(strings.subList(0, start));
                    }
                    // merge elements from start index to end index
                    //  Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
                    if (start < strings.size()) {

                        List<String> mergeElements = strings.subList(start, end + 1);
                        String merged = "";
                        for (String mergeElement : mergeElements) {
                            merged += mergeElement;
                        }
                        result.add(merged);
                    }
                    // add what remains of the list
                    if (end + 1 < strings.size()) {
                        result.addAll(strings.subList(end + 1, strings.size()));
                    }
                    if (!result.isEmpty()) {
                        strings = result;
                    }

                    break;
                case "divide":
                    result = new ArrayList<>();
                    int index = Integer.parseInt(commands[1]);
                    int parts = Integer.parseInt(commands[2]);
                    String element = strings.get(index);
                    if (element.length() % parts == 0) {
                        int symbols = element.length() / parts;
                        // ab cd ef
                        for (int i = 0; i < parts; i++) {
                            //  add first element to result List
                            result.add(element.substring(0, symbols));
                            // remove first element from the string
                            element = element.substring(symbols);
                        }
                        strings.remove(index);
                        strings.addAll(index, result);

                    } else {
                        int symbols = element.length() / parts;
                        // { abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
                        for (int i = 0; i < parts; i++) {
                            if (i == parts - 1) {
                                result.add(element);
                            } else {
                                //  add first element to result List
                                result.add(element.substring(0, symbols));
                                // remove first element from the string
                                element = element.substring(symbols);

                            }
                        }
                        strings.remove(index);
                        strings.addAll(index, result);
                    }

                    break;
            }

            line = scanner.nextLine();
        }
        strings.forEach(s -> System.out.print(s + " "));
    }
}
