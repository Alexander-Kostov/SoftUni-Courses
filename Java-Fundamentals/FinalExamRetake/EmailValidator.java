package FinalExamRetake;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String line = scanner.nextLine();

        while (!line.equals("Complete")) {
            String[] data = line.split(" ");
            String command = data[0];

            switch (command) {
                case "Make":
                    String subCommand = data[1];
                    if (subCommand.equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);

                    } else if (subCommand.equals("Lower")) {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;
                case "GetDomain":
                int count = Integer.parseInt(data[1]);
                int secondCount = 0;
                String secondEmail = "";
                    for (int i = email.length() - 1; i >= 0; i--) {
                        if (secondCount == count){
                            break;
                        }
                        secondEmail += email.charAt(i);
                        secondCount++;
                    }

                    for (int i = secondEmail.length() - 1; i >= 0; i--) {
                        System.out.printf("%c",secondEmail.charAt(i));
                    }
                    System.out.println();
                    break;
                case "GetUsername":
                    boolean containsSymbol = email.contains("@");
                    if (containsSymbol){
                        int index = email.indexOf("@");
                        String username = email.substring(0,index);
                        System.out.println(username);
                    }else {
                        System.out.printf("The email %s doesn't contain the @ symbol.\n",email);
                    }

                    break;
                case "Replace":
                    String occurrence = data[1];
                    email = email.replace(occurrence,"-");
                    System.out.println(email);

                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        int symbol = email.charAt(i);
                        System.out.printf("%d ",symbol);
                    }
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
