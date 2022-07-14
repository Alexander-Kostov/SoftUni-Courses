package MethodsLab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int repetitions = Integer.parseInt(scanner.nextLine());

        String repeated = repeatString(name, repetitions);

        System.out.println(repeated);
    }

    private static String repeatString(String s, int repetitions) {
        String [] strings = new String[repetitions];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = s;
        }

        return String.join("",strings);
    }


}
