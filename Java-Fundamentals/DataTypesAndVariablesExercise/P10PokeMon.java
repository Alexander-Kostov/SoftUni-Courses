package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());

        int firstN = N;
        int targetsCount = 0;


        while (N >= M) {
            targetsCount++;
            N -= M;
            if (N == firstN * 0.50) {
                if (Y != 0) {
                    N /= Y;
                }
            }
        }

        System.out.println(N);
        System.out.println(targetsCount);
    }
}
