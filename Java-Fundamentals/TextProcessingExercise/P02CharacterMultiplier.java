package TextProcessingExercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] usernames = scanner.nextLine().split(" ");

        char [] first = usernames[0].toCharArray();
        char [] second = usernames[1].toCharArray();

        int sum = 0;

        int maxLength = Math.max(first.length,second.length);
        int minLength = Math.min(first.length,second.length);

        for (int i = 0; i < maxLength; i++) {
            if (i < minLength){
                sum += first[i] * second[i];
            } else if (first.length > second.length){
                sum += first[i];
            }else {
                sum += second[i];
            }
        }

        System.out.println(sum);
    }
}
