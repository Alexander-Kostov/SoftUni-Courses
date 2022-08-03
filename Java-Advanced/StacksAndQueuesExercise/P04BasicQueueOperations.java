package JavaAdvance.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int elementsToAdd = scanner.nextInt();
        int elementsToRemove = scanner.nextInt();
        int elementToCheck = scanner.nextInt();

        for (int i = 0; i < elementsToAdd; i++) {
            queue.add(scanner.nextInt());
        }

        for (int i = 0; i < elementsToRemove; i++) {
            queue.remove();
        }

        if (queue.size() == 0) {
            System.out.println(0);
        } else if (queue.contains(elementToCheck)) {
            System.out.println(true);
        } else {
            System.out.println(queue.stream().min(Integer::compare).get());
        }

    }
}
