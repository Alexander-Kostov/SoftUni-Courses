package ArraysExcercise;

import java.util.Scanner;

public class P09KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        String index = "";
        int count = 0;
        int maxCount = 0;

        int maxLength = 0;
        int maxSum = 0;
        int bestDnaPosition = 0;

        String[] bestDna = new String[n];

        while (!line.equals("Clone them!")) {
            count++;
            String data = line.replaceAll("!", "");
            String[] dna = data.split("0");
            int currentLength = 0;
            int currentSum = 0;

            for (int i = 0; i < dna.length; i++) {
                currentSum += dna[i].length();
                if (dna[i].length() > currentLength) {
                    currentLength = dna[i].length();
                    index = dna[i];
                }
            }
            int currentPosition = data.indexOf(index);

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxSum = currentSum;
                maxCount = count;
                bestDnaPosition = currentPosition;
                bestDna = data.split("");
            } else if (currentLength == maxLength && (bestDnaPosition > currentPosition || currentSum > maxSum)) {
                maxSum = currentSum;
                maxCount = count;
                bestDnaPosition = currentPosition;
                bestDna = data.split("");
            } else if (count == 1) {
                maxLength = currentLength;
                maxSum = currentSum;
                maxCount = count;
                bestDnaPosition = currentPosition;
                bestDna = data.split("");
            }


            line = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.\n", maxCount, maxSum);
        System.out.println(String.join(" ", bestDna));
    }
}
