package JavaAdvance.StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        Collections.addAll(arrayDeque,input);


        while (arrayDeque.size() > 1){
            int firstNum = Integer.parseInt(arrayDeque.pop());
            String sign = arrayDeque.pop();
            int secondNum = Integer.parseInt(arrayDeque.pop());

            if (sign.equals("+")){
                int result = firstNum + secondNum;
                arrayDeque.push(String.valueOf(result));
            }else if (sign.equals("-")){
                int result = firstNum - secondNum;
                arrayDeque.push(String.valueOf(result));
            }
        }
        System.out.println(arrayDeque.pop());
    }
}
