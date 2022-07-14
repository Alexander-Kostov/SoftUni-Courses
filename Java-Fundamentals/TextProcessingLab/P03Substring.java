package TextProcessingLab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removingWord = scanner.nextLine();
        String sequence = scanner.nextLine();

        int index = sequence.indexOf(removingWord);

        while (index != -1){
            String firstPart = sequence.substring(0,index);
            String secondPart = sequence.substring(index + removingWord.length());
            sequence = firstPart + secondPart;

            index = sequence.indexOf(removingWord);
        }

        System.out.println(sequence);
    }
}
