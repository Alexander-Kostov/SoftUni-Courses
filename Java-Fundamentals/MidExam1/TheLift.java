package MidExam1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int [] lift = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            while (lift[i] < 4 && people > 0){
                lift[i]++;
                people--;
                if (lift[i] == 4 || people == 0){
                    break;
                }
            }
        }


        boolean hasSpots = false;

        for (int i = 0; i < lift.length; i++) {
            if (lift[i] < 4){
                hasSpots = true;
                break;
            }
        }

        if (hasSpots && people == 0) {
            System.out.println("The lift has empty spots!");
        }else if (!hasSpots && people > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }

        for (int i : lift) {
            System.out.printf("%d ",i);
        }
    }
}
