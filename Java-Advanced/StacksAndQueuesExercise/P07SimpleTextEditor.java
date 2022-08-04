package JavaAdvance.StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<Integer> previousCommands = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(" ");
            int command = Integer.parseInt(commands[0]);
            switch (command) {
                case 1:
                    previousCommands.push(1);
                    String lettersToAppend = commands[1];
                    stack.push(lettersToAppend);
                    text.append(lettersToAppend);
                    break;
                case 2:
                    previousCommands.push(2);
                    int lettersToRemove = Integer.parseInt(commands[1]);
                    StringBuilder letters = new StringBuilder();

                    for (int j = 1; j <= lettersToRemove; j++) {
                        letters.append(text.charAt(text.length() - 1));
                        text.deleteCharAt(text.length() - 1);
                    }
                    letters.reverse();
                    stack.push(letters.toString());
                    break;
                case 3:
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    int previous = previousCommands.pop();
                    switch (previous){
                        case 1:
                            String appendedLetters = stack.pop();
                            for (int j = 0; j < appendedLetters.length(); j++) {
                                text.deleteCharAt(text.length() - 1);
                            }
                            break;
                        case 2:
                            String deletedLetters = stack.pop();
                            text.append(deletedLetters);
                            break;
                    }
                    break;

            }
        }


    }
}
