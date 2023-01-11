package WorkingWithAbstractionExercise.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getPosition(scanner.nextLine());
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] galaxy = new int[x][y];

        extracted(x, y, galaxy);

        String command = scanner.nextLine();
        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = getPosition(command);
            int[] evilPosition = getPosition(scanner.nextLine());
            int currentRowEvil = evilPosition[0];
            int currentColEvil = evilPosition[1];

            while (currentRowEvil >= 0 && currentColEvil >= 0) {
                if (currentRowEvil < galaxy.length && currentColEvil < galaxy[0].length) {
                    galaxy[currentRowEvil][currentColEvil] = 0;
                }
                currentRowEvil--;
                currentColEvil--;
            }

            int currentRowJedi = jediPosition[0];
            int currentColJedi = jediPosition[1];

            while (currentRowJedi >= 0 && currentColJedi < galaxy[1].length) {
                if (currentRowJedi < galaxy.length && currentColJedi >= 0 && currentColJedi < galaxy[0].length) {
                    starsCollected += galaxy[currentRowJedi][currentColJedi];
                }

                currentColJedi++;
                currentRowJedi--;
            }

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);


    }


    private static int[] getPosition(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void extracted(int x, int y, int[][] galaxy) {
        int value = 0;
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                galaxy[row][col] = value++;
            }
        }
    }
}
