package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        String winnerKeg = "";
        double maxKeg = 0;


        for (int i = 0; i < n; i++) {
            String kegModel = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            int kegHeight = Integer.parseInt(scanner.nextLine());

            double kegVolume = Math.PI * kegRadius * kegRadius * kegHeight;
            if (kegVolume > maxKeg){
                maxKeg = kegVolume;
                winnerKeg = kegModel;
            }

        }

        System.out.printf("%s", winnerKeg);
    }
}
