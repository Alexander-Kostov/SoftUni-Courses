package RegularExperssionsExercise;

import java.util.*;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> mealList = new LinkedHashMap<>();
        int dislikedMealsCount = 0;

        while (!input.equals("Stop")) {
            String[] data = input.split("-");
            String command = data[0];

            switch (command) {
                case "Like":
                    String guest = data[1];
                    String meal = data[2];
                    mealList.putIfAbsent(guest, new ArrayList<>());
                    if (!mealList.get(guest).contains(meal)) {
                        mealList.get(guest).add(meal);
                    }
                    break;
                case "Dislike":
                    guest = data[1];
                    meal = data[2];
                    if (!mealList.containsKey(guest)) {
                        System.out.printf("%s is not at the party.\n", guest);
                    } else if (!mealList.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.\n", guest, meal);
                    } else {
                        mealList.get(guest).remove(meal);
                        dislikedMealsCount++;
                        System.out.printf("%s doesn't like the %s.\n", guest, meal);
                    }
                    break;

            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : mealList.entrySet()) {
            if (mealList.size() == 1 && entry.getValue().size() == 0){
                System.out.printf("%s: \n",entry.getKey());
                break;
            }
            System.out.printf("%s: ", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (i == entry.getValue().size() - 1) {
                    System.out.printf("%s\n", entry.getValue().get(i));
                    break;
                }
                System.out.printf("%s, ", entry.getValue().get(i));
            }

        }
//        mealList.forEach((k, v) ->{
//            if (v.size() != 0){
//                System.out.printf("");
//            }
//        });

        System.out.printf("Unliked meals: %d",dislikedMealsCount);
    }
}

