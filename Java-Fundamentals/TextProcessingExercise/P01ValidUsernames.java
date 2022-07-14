package TextProcessingExercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (int i = 0; i < usernames.length; i++) {
            String name = usernames[i];
            boolean validLength = getLength(name);
            boolean validLetters = getLetters(name);

            if (validLength && validLetters) {
                System.out.println(name);
            }
        }

    }

    private static boolean getLetters(String username) {
        return username.length() >= 3 && username.length() <= 16;
    }

    private static boolean getLength(String username) {

        for (int i = 0; i < username.length(); i++) {
            char symbol = username.toUpperCase().charAt(i);

            if (symbol == 45 || (symbol >= 48 && symbol <= 57) || (symbol >= 65 && symbol <= 90) || symbol == 95){

            }else {
                return false;
            }

        }
        return true;
    }
}
