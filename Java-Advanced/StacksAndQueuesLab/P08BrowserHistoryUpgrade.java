package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String url = scanner.nextLine();
        String currentUrl = "";

        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (history.size() > 1) {
                    currentUrl = history.pop();
                    forwardHistory.addFirst(currentUrl);
                    System.out.println(history.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (url.equals("forward")) {
                if (forwardHistory.size() > 0) {
                    currentUrl = forwardHistory.remove();
                    history.push(currentUrl);
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                history.push(url);
                forwardHistory.clear();
                System.out.println(url);
            }


            url = scanner.nextLine();
        }
    }
}
