package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String url = scanner.nextLine();

        while (!url.equals("Home")) {
            if (url.equals("back")){
                if (history.size() > 1) {
                    history.pop();
                    System.out.println(history.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }else {
                history.push(url);
                System.out.println(history.peek());
            }


            url = scanner.nextLine();
        }

    }
}
