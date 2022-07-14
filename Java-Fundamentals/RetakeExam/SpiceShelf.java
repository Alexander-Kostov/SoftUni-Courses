package RetakeExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpiceShelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> spices = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
//        List<String> spices = new ArrayList<>(Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList()));


        String input = scanner.nextLine();

        while (!input.equals("done")){
            String [] data = input.split(" ");
            String command = data[0];

            switch (command){
                case "AddSpice":
                    String spice = data[1];
                    boolean contains = spices.contains(spice);
                    if (!contains){
                        spices.add(spice);
                    }
                    break;
                case "AddManySpices":
                    int index = Integer.parseInt(data[1]);
                    String[] currentSpices = data[2].split("[|]");
                    for (int i = currentSpices.length - 1; i >= 0; i--) {
                        spices.add(index, currentSpices[i]);
                    }
                    break;
                case "SwapSpices":
                    String firstSpice = data[1];
                    String secondSpice = data[2];
                    boolean firstSpiceExists = spices.contains(firstSpice);
                    boolean secondSpiceExists = spices.contains(secondSpice);
                    if (firstSpiceExists && secondSpiceExists){
                        int firstSpiceIndex = spices.indexOf(firstSpice);
                        int secondSpiceIndex = spices.indexOf(secondSpice);
                        spices.remove(firstSpiceIndex);
                        spices.add(firstSpiceIndex,secondSpice);
                        spices.remove(secondSpiceIndex);
                        spices.add(secondSpiceIndex,firstSpice);

                    }
                    break;
                case "ThrowAwaySpices":
                    // check again
                    spice = data[1];
                    index = Integer.parseInt(data[2]);
                    boolean containsSpice = spices.contains(spice);
                    int currentIndex = spices.indexOf(spice);
                    int count = 0;
                    if (containsSpice){
                        for (int i = currentIndex; i < index; i++) {
                            if (count == index){
                                break;
                            }
                            spices.remove(i);
                            count++;
                            i--;

                        }
                    }
                    break;
                case "Arrange":
                List<String> sortedList = spices.stream().sorted().collect(Collectors.toList());
                spices.clear();
                spices.addAll(sortedList);

                    break;

            }

            input = scanner.nextLine();
        }

        for (String spice : spices) {
            System.out.printf("%s ",spice);
        }
    }
}
