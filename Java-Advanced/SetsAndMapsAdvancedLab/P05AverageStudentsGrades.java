package JavaAdvance.SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(" ");
            String student = data[0];
            double grade = Double.parseDouble(data[1]);

            students.putIfAbsent(student, new ArrayList<>());
            students.get(student).add(grade);
        }

        // another way:

//        students.entrySet().forEach(e -> {
//            double sum = 0;
//
//            for (Double grade : e.getValue()) {
//                sum += grade;
//            }
//            double average = sum / e.getValue().size();
//
//            System.out.print(e.getKey() + " -> ");
//            for (Double aDouble : e.getValue()) {
//                System.out.printf("%.2f ",aDouble);
//            }
//            System.out.printf("(avg: %.2f)\n",average);
//        });

        students.forEach((key,value) -> {
            double sum = 0;
            for (Double grade : value) {
                sum += grade;
            }
            double averageGrade = sum / value.size();

            System.out.println(key + " -> " + value.stream().map(x -> String.format("%.2f",x)).collect(Collectors.joining(" ")) +
                   " (avg: " + String.format("%.2f", averageGrade) + ")");
        });


    }
}
