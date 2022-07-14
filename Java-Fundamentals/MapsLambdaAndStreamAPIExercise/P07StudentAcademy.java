package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(student)) {
                students.put(student, new ArrayList<>());
                students.get(student).add(grade);
            } else {
                students.get(student).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> stringListEntry : students.entrySet()) {
            List<Double> numbers = stringListEntry.getValue();
            double sum = 0;
            for (Double currentSum : numbers) {
                sum += currentSum;
            }

            double finalSum = sum / numbers.size();
            if (finalSum >= 4.50){
                System.out.printf("%s -> %.2f\n",stringListEntry.getKey(),finalSum);
            }


        }

//        students.entrySet().stream().filter(s -> s.getValue().stream().
//                mapToDouble(x -> x).average().orElse(0.00) >= 4.50).
//                forEach(entry -> {
//                    double averageGrade = entry.getValue().stream().mapToDouble(x -> x).average().orElse(0.0);
//                    System.out.printf("%s -> %.2f\n", entry.getKey(),averageGrade);
//                });
    }
}
