package TextProcessingLab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String censored = repeat("*", bannedWord.length());
            text = text.replace(bannedWord,censored);

        }

        System.out.println(text);
    }
    static String repeat (String word, int repetitions){
        char[] repeated = new char[word.length() * repetitions];

        for (int i = 0; i < repeated.length; i++) {
            repeated[i] = word.charAt(i % word.length());
        }

        return new String(repeated);
    }
}
