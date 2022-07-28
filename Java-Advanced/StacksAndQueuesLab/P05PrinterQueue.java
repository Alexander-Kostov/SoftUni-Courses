package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> printer = new ArrayDeque<>();

        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (printer.size() > 0){
                    String removedSheet = printer.remove();
                    System.out.printf("Canceled %s\n",removedSheet);
                }else {
                    System.out.println("Printer is on standby");
                }
            }else {
                printer.add(input);
            }

            input = scanner.nextLine();
        }

        for (String s : printer) {
            System.out.println(s);
        }
    }
}
