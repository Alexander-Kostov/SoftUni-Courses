package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(data[1]);
                    if (isValid(index, arr.length)) {
                        exchange(arr, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (data[1].equals("odd")) {
                        maxOdd(arr);
                    } else {
                        maxEven(arr);
                    }
                    break;
                case "min":
                    if (data[1].equals("odd")) {
                        minOdd(arr);
                    } else {
                        minEven(arr);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(data[1]);
                    if (count > arr.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (data[2].equals("odd")) {
                            firstOdd(arr, count);
                        } else {
                            firstEven(arr, count);
                        }
                    }
                    break;
                case "last":
                    count = Integer.parseInt(data[1]);
                    if (count > arr.length){
                        System.out.println("Invalid count");
                    } else {
                        if (data[2].equals("odd")){
                            oddLast(arr,count);
                        } else {
                            evenLast(arr,count);
                        }
                    }
                    break;

            }


            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void printArr (int[] array){
        System.out.print("[");
        boolean isFirst = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                if (isFirst){
                    System.out.print(array[i]);
                    isFirst = false;
                } else {
                    System.out.print(", " + array[i]);
                }
            }

        }
        System.out.println("]");
    }

    private static void evenLast(int[] array, int count) {
        int [] bufferArr = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0 && count > 0){
                bufferArr[i] = array[i];
                count--;
            } else {
                bufferArr[i] = -1;
            }
        }
        printArr(bufferArr);
    }

    private static void oddLast(int[] array, int count) {
        int [] bufferArr = new int[array.length];
        for (int i = array.length - 1; i >= 0 ; i--) {
            if (array[i] % 2 != 0 && count > 0){
                bufferArr[i] = array[i];
                count--;
            } else {
                bufferArr[i] = -1;
            }
        }
        printArr(bufferArr);
    }

    private static void firstEven(int[] array, int count) {
        int[] bufferArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && count > 0) {
                bufferArr[i] = array[i];
                count--;
            } else {
                bufferArr[i] = -1;
            }
        }
        printArr(bufferArr);
    }

    private static void firstOdd(int[] array, int count) {
        int[] bufferArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && count > 0) {
                bufferArr[i] = array[i];
                count--;
            } else {
                bufferArr[i] = -1;
            }
        }
        printArr(bufferArr);
    }

    private static void minEven(int[] array) {
        int minNum = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (minNum >= array[i] && array[i] % 2 == 0) {
                minNum = array[i];
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    private static void minOdd(int[] array) {
        int minNum = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (minNum >= array[i] && array[i] % 2 != 0) {
                minNum = array[i];
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }


    public static boolean isValid(int index, int length) {
        return index >= 0 && index < length;
    }

    public static void exchange(int[] array, int index) {
        int[] first = new int[index + 1];
        int[] second = new int[array.length - index - 1];

        for (int i = 0; i < first.length; i++) {
            first[i] = array[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = array[index + 1 + i];
        }

        for (int i = 0; i < array.length; i++) {
            if (i < second.length) {
                array[i] = second[i];
            } else {
                array[i] = first[i - second.length];
            }
        }
    }

    public static void maxOdd(int[] array) {
        int maxNumber = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (maxNumber <= array[i] && array[i] % 2 != 0) {
                maxNumber = array[i];
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("No matches");

        } else {
            System.out.println(index);
        }
    }

    private static void maxEven(int[] array) {
        int maxNumber = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (maxNumber <= array[i] && array[i] % 2 == 0) {
                maxNumber = array[i];
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }

    }
}
