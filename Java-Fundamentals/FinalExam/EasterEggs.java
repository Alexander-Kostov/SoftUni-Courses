package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        String regex = "[@#]+(?<Color>[a-z]{3,})[@#]+[^A-Za-z0-9]*/+(?<number>\\d+)/+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.printf("You found %s %s eggs!\n",matcher.group("number"),matcher.group("Color"));
        }
    }
}
