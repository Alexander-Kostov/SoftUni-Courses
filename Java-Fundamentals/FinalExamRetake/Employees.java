package FinalExamRetake;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "((?<name>[A-Z][a-z]{2,} [A-Z][a-z]{2,})#+(?<position>([A-Z][a-z]+&?){1,3})\\d{2}(?<company>[A-Z][A-z\\d]+ ((Ltd.)|(JSC))))";
        Pattern pattern = Pattern.compile(regex);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
             String name = matcher.group("name");
             String position = matcher.group("position");
             String company = matcher.group("company");
             String [] alPositions = position.split("&");

                System.out.printf("%s is %s at %s\n",name,String.join(" ",alPositions),company);
            }
        }

    }
}
