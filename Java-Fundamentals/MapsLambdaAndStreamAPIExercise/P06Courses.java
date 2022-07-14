package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String [] data = input.split(" : ");
            String course = data[0];
            String student = data[1];

            if (!courses.containsKey(course)){
                 courses.put(course,new ArrayList<>());
                 courses.get(course).add(student);
            }else {
                courses.get(course).add(student);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(),entry.getValue().size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s\n",entry.getValue().get(i));
            }
        }

    }
}
