package MethodsExercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (passwordValidation(password) && passwordLetterAndDigits(password) && passwordMustHave2Digits(password)){
            System.out.println("Password is valid");
        }
        if (!passwordValidation(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!passwordLetterAndDigits(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!passwordMustHave2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
    }
    public static boolean passwordValidation (String password){
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;

    }
    public static boolean passwordLetterAndDigits(String password){
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.toLowerCase().charAt(i);
            if ((symbol < 48 || symbol > 59)&& (symbol < 97 || symbol > 122)) {
                return false;
            }
        }
            return true;
    }
    public static boolean passwordMustHave2Digits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                count++;
            }

        }
            return count >=2;
    }
}
