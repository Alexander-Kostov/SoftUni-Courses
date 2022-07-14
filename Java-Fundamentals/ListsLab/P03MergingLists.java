package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listA = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> listB = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> finalList = new ArrayList<>();

        int indexA = 0;
        int indexB = 0;


        while (indexA < listA.size() || indexB < listB.size()) {
            if (indexA >= listA.size()) {
                finalList.add(listB.get(indexB));
                indexB++;
                continue;
            } else {
                finalList.add(listA.get(indexA));
                indexA++;

            }
            if (indexB >= listB.size()) {
                continue;
            } else {
                finalList.add(listB.get(indexB));
                indexB++;

            }
        }

        for (int i = 0; i < finalList.size(); i++) {
            System.out.print(finalList.get(i) + " ");
        }


    }
}
