package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double[]> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String student = scanner.nextLine();
            Double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).toArray(Double[]::new);

            students.put(student,grades);
        }

        students.entrySet().forEach(e -> {
            double sum = 0;
            for (Double grade : e.getValue()) {
                sum += grade;
            }

            System.out.printf("%s is graduated with %s\n",e.getKey(),sum / e.getValue().length);
        });

    }
}
