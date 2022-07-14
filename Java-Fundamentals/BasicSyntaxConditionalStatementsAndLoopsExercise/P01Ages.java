package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String type = "";

        if (n >= 0 && n <= 2) {
        type = "baby";
        } else if  (n <= 13) {
            type = "child";
        }else if (n <= 19) {
            type = "teenager";
        }else if (n <= 65) {
            type = "adult";
        } else  {
            type = "elder";
        }

        System.out.printf("%s",type);
    }
}

