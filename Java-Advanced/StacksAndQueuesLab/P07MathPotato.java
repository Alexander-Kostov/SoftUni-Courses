package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int rounds = 1;
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);

        while (kids.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentChild = kids.poll();
                kids.offer(currentChild);
            }
            if (forRemoving(rounds)){
                System.out.println("Removed " + kids.poll());
            }else {
                System.out.println("Prime " + kids.peek());
            }
            rounds++;
        }
        System.out.println("Last is " + kids.peek());
    }

    public static boolean forRemoving(int rounds) {
        if (rounds == 1 || rounds == 4) {
            return true;
        }
        if (rounds > 5 && (rounds % 2 == 0 || rounds % 3 == 0 || rounds % 5 == 0)) {
            return true;
        }
        return false;
    }
}
