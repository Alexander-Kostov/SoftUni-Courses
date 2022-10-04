package P03StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String command;
        StackIterator current = new StackIterator();
        while (!"END".equals(command = console.nextLine())) {
            String[] tokens = command.split("\\s+|,\\s+");
            switch (tokens[0]) {
                case "Push":
                    current.push(Arrays.copyOfRange(tokens, 1, tokens.length));
                    break;
                case "Pop":
                    try {
                        current.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        StackIterator.print(current);
        StackIterator.print(current);
    }
}
