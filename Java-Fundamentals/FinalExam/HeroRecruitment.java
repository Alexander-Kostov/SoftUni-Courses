package FinalExam;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> heroes = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "Enroll":
                    String hero = data[1];
                    if (!heroes.containsKey(hero)) {
                        heroes.put(hero, new ArrayList<>());
                    } else {
                        System.out.printf("%s is already enrolled.\n", hero);
                    }

                    break;
                case "Learn":
                    hero = data[1];
                    String spell = data[2];
                    if (heroes.containsKey(hero)) {
                        if (!heroes.get(hero).contains(spell)) {
                            heroes.get(hero).add(spell);
                        }else {
                            System.out.printf("%s has already learnt %s.%n",hero,spell);
                        }
                    }else {
                        System.out.printf("%s doesn't exist.%n",hero);
                    }

                    break;
                case "Unlearn":
                    hero = data[1];
                    spell = data[2];
                    if (heroes.containsKey(hero)) {
                        if (heroes.get(hero).contains(spell)) {
                            heroes.get(hero).remove(spell);
                        } else {
                            System.out.printf("%s doesn't know %s.%n",hero,spell);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n",hero);
                    }
                    break;

            }

            input = scanner.nextLine();
        }

        System.out.println("Heroes:");
//        for (Map.Entry<String, List<String>> entry : heroes.entrySet()) {
//            System.out.printf("== %s: ", entry.getKey());
//            if (entry.getValue().size() == 0) {
//                System.out.println();
//            }
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                System.out.printf("%s ", entry.getValue().get(i));
//            }
//            if (entry.getValue().size() != 0) {
//                System.out.println();
//            }
//        }

        heroes.forEach((k,v)-> {
            System.out.printf("== %s: ",k);
            for (int i = 0; i < v.size(); i++) {
                System.out.printf("%s \n", v.get(i));
            }
            System.out.println();
        });
    }
}
