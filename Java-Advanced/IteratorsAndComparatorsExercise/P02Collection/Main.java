package P02Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String command;
        ListyIterator current = null;
        while (!"END".equals(command = console.nextLine())) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Create":
                    current = new ListyIterator(Arrays.copyOfRange(token,1,token.length));
                    break;
                case "Move":
                    System.out.println(current.Move());
                    break;
                case "Print":
                    current.Print();
                    break;
                case "PrintAll":
                    current.PrintAll();
                    break;
                case "HasNext":
                    System.out.println(current.hasNext());
                    break;
            }
        }
    }
}