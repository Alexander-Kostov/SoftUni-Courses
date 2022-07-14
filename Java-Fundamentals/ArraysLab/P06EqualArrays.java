package ArraysLab;

import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        String[] firstArray = firstLine.split(" ");
        String[] secondArray = secondLine.split(" ");

        int index = 0;
        int sum = 0;
        boolean isEqual;

        if (firstArray.length == secondArray.length){
            isEqual = true;
            for (int i = 0; i < firstArray.length; i++) {
                int firstArrayNumber = Integer.parseInt(firstArray[i]);
                int secondArrayNumber = Integer.parseInt(secondArray[i]);

                if (firstArrayNumber == secondArrayNumber){
                    int currentNumber = Integer.parseInt(firstArray[i]);
                    sum += currentNumber;
                } else {
                    index = i;
                    isEqual = false;
                    break;
                }
            }
        } else {
            isEqual = false;

        }

        if (isEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.",index);
        }
    }
}
