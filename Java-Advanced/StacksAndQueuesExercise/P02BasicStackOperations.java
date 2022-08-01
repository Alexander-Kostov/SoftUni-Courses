package JavaAdvance.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int elementsToPush = scanner.nextInt();
        int elementsToPop = scanner.nextInt();
        int elementsToCheck = scanner.nextInt();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.size() == 0){
            System.out.println(0);
        } else if (stack.contains(elementsToCheck)){
            System.out.println("true");
        }else {
            System.out.println(stack.stream().min(Integer::compare).get());

        }

    }
}
