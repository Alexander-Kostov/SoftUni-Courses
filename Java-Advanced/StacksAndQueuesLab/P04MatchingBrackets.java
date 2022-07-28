package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> brackets = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);

            if (currentSymbol == '(') {
                brackets.push(i);
            } else if (currentSymbol == ')') {
                int lastOpenIndex = brackets.pop();
                String matchingBracket = expression.substring(lastOpenIndex, i + 1);
                System.out.println(matchingBracket);
            }
        }
    }
}
