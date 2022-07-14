package RegularExperssionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialParticipants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, Integer> renderedParticipants = new LinkedHashMap<>();
        for (String initialParticipant : initialParticipants) {
            renderedParticipants.putIfAbsent(initialParticipant, 0);
        }
        String regexName = "[A-Za-z]+";
        String regexDistance = "[\\d+]{1}";
        Pattern name = Pattern.compile(regexName);
        Pattern distance = Pattern.compile(regexDistance);

        String info = scanner.nextLine();

        while (!info.equals("end of race")) {
            Matcher matcher = name.matcher(info);
            StringBuilder participant = new StringBuilder();
            while (matcher.find()) {
                participant.append(matcher.group());
            }

            if (renderedParticipants.containsKey(participant.toString())) {
                Matcher distanceMatcher = distance.matcher(info);
                while (distanceMatcher.find()) {
                    int digit = Integer.parseInt(distanceMatcher.group());
                    renderedParticipants.put(participant.toString(), renderedParticipants.get(participant.toString()) + digit);
                }
            }

            info = scanner.nextLine();
        }

        List<String> sorted = renderedParticipants.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            if (i == 3) {
                break;
            }
            if (i == 0) {
                System.out.printf("1st place: %s\n", sorted.get(i));
            } else if (i == 1) {
                System.out.printf("2nd place: %s\n", sorted.get(i));
            } else if (i == 2) {
                System.out.printf("3rd place: %s\n", sorted.get(i));
            }
        }

    }
}
