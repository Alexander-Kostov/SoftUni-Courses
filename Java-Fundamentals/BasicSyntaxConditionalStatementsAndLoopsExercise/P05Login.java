package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        boolean flag = false;

        for (int i = username.length() - 1; i >= 0 ; i--) {
            password += username.charAt(i);

        }

        String loginAttempt = scanner.nextLine();

        int count = 0;

        while (!loginAttempt.equals(password)){
            count++;
            if (count == 4){
                System.out.printf("User %s blocked!%n", username);
                flag = true;
                break;

            }

            System.out.println("Incorrect password. Try again.");
            loginAttempt = scanner.nextLine();
        }

        if (!flag){
            System.out.printf("User %s logged in.", username);
        }
    }
}
