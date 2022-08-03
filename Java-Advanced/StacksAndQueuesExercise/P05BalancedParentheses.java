package JavaAdvance.StacksAndQueuesExercise;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        boolean isEqual = false;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == ']' || symbol == '}') {
                if (stack.isEmpty()){
                    isEqual = false;
                    break;
                }
                char lastOpenBracket = stack.pop();
                if (symbol == '}' && lastOpenBracket == '{'){
                    isEqual = true;
                }else if (symbol == ']' && lastOpenBracket == '['){
                    isEqual = true;
                }else if (symbol == ')' && lastOpenBracket == '('){
                    isEqual = true;
                } else {
                    isEqual = false;
                    break;
                }
            }

        }
        if (isEqual){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
