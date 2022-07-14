package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> companiesInfo = new LinkedHashMap<>();

        while (!input.equals("End")){
            String [] data = input.split(" -> ");
            String company = data[0];
            String employee = data[1];

            if (!companiesInfo.containsKey(company)){
                companiesInfo.put(company,new ArrayList<>());
            }
            if (!companiesInfo.get(company).contains(employee)){
                companiesInfo.get(company).add(employee);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companiesInfo.entrySet()) {
            System.out.printf("%s\n", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s\n",entry.getValue().get(i));
            }
        }
    }
}
