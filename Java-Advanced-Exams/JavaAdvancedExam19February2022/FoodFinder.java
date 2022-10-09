package JavaAdvancedExam19February2022;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vowels = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> consonants = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

//        char[] vowels = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.joining()).toCharArray();
//        char[] consonants = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.joining()).toCharArray();


        for (int i = 0; i < vowels.size() - 1; i++) {
            String vowelToCompare = vowels.get(i);
            for (int j = i; j < vowels.size() - 1; j++) {
                if (vowelToCompare.equals(vowels.get(j + 1))) {
                    vowels.remove(vowels.get(j + 1));
                    i--;
                }
            }
        }

        for (int i = 0; i < consonants.size() - 1; i++) {
            String consonantToCompare = consonants.get(i);
            for (int j = i; j < consonants.size() - 1; j++) {
                if (consonantToCompare.equals(consonants.get(j + 1))) {
                    consonants.remove(consonants.get(j + 1));
                    i--;
                }
            }
        }
        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        System.out.println();
        for (String vowel : vowels) {
            vowelsQueue.offer(vowel);
        }

        for (String consonant : consonants) {
            consonantsStack.push(consonant);
        }


        String pear = "pear";
        int pearCounter = 0;
        String flour = "flour";
        int flourCounter = 0;
        String pork = "pork";
        int porkCounter = 0;
        String olive = "olive";
        int oliveCounter = 0;
        int rounds = 0;

        int vowelsSize = vowelsQueue.size();
        while (!consonantsStack.isEmpty()) {
            String consonant = consonantsStack.pop();
            if (rounds >= vowelsSize) {
                pearCounter = checkLetter(pear, pearCounter, consonant);
                flourCounter = checkLetter(flour, flourCounter, consonant);
                porkCounter = checkLetter(pork, porkCounter, consonant);
                oliveCounter = checkLetter(olive, oliveCounter, consonant);
                continue;
            }
            String vowel = vowelsQueue.poll();

            pearCounter = checkLetter(pear, pearCounter, consonant);
            pearCounter = checkLetter(pear, pearCounter, vowel);

            flourCounter = checkLetter(flour, flourCounter, consonant);
            flourCounter = checkLetter(flour, flourCounter, vowel);

            porkCounter = checkLetter(pork, porkCounter, consonant);
            porkCounter = checkLetter(pork, porkCounter, vowel);

            oliveCounter = checkLetter(olive, oliveCounter, consonant);
            oliveCounter = checkLetter(olive, oliveCounter, vowel);
            vowelsQueue.offer(vowel);
            rounds++;
        }

        List<String> words = new ArrayList<>();

        checkWord(pear, pearCounter, words, pear.length());
        checkWord(flour, flourCounter, words, flour.length());
        checkWord(pork, porkCounter, words, pork.length());
        checkWord(olive, oliveCounter, words, olive.length());

        System.out.println("Words found: " + words.size());
        for (String word : words) {
            System.out.println(word);
        }


    }
//o e u i y
//p f l v f r k p

    private static void checkWord(String word, int counter, List<String> words, int length) {
        if (counter >= length) {
            words.add(word);
        }
    }

    private static int checkLetter(String word, int counter, String letter) {
        char letterToCompare = letter.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letterToCompare) {
                counter++;
            }
        }
        return counter;
    }
}
