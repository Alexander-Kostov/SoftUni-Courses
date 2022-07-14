package FinalExam1;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String line = scanner.nextLine();
        while (!line.equals("Decode")) {
            String[] data = line.split("\\|");
            String command = data[0];

            switch (command) {
                case "Move":
                    int index = Integer.parseInt(data[1]);
                    String first = text.substring(0, index);
                    String second = text.substring(index);
                    text = second.concat(first);
                    break;
                case "Insert":
                    index = Integer.parseInt(data[1]);
                    String value = data[2];
                    first = text.substring(0,index);
                    second = text.substring(index);
                    text = first.concat(value).concat(second);
                    break;
                case "ChangeAll":
                    String substring = data[1];
                    String replacement = data[2];
                    text = text.replace(substring,replacement);
                    break;

            }

            line = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s\n",text);
    }
}
