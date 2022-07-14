package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, List<String>> submissions = new LinkedHashMap<>();


        while (!input.equals("exam finished")) {
            if (input.contains("banned")){
                String [] data = input.split("-");
                String name = data[0];

                results.remove(name);
                input = scanner.nextLine();
                continue;
            }

            String[] data = input.split("-");

            String name = data[0];
            String language = data[1];
            int points = Integer.parseInt(data[2]);
            String current = "1";

            results.putIfAbsent(name, points);{
                if (results.get(name) < points){
                    results.replace(name,points);
                }
            }
            submissions.putIfAbsent(language,new ArrayList<>());
            submissions.get(language).add(current);

            input = scanner.nextLine();
        }

        System.out.println("Results: ");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.printf("%s | %s\n",entry.getKey(),entry.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, List<String>> entry : submissions.entrySet()) {
            System.out.printf("%s - %d\n",entry.getKey(),entry.getValue().size());
        }
    }
}
