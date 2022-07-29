package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids,input);

        while (kids.size() > 1){
            for (int i = 1; i < n; i++) {
                String currentChild = kids.poll();
                kids.offer(currentChild);
            }
            String removedKid = kids.remove();
            System.out.printf("Removed %s\n", removedKid);
        }
        System.out.println("Last is " + kids.peek());

    }
}
