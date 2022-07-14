package MapsLambdaAndStreamAPILab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String [] sequenceOfWords = line.split(" ");

        Map<String,Integer> oddTimes = new LinkedHashMap<>();

        for (String word : sequenceOfWords) {
            String wordToLowerCase = word.toLowerCase();

            if (oddTimes.containsKey(wordToLowerCase)){
                oddTimes.put(wordToLowerCase, oddTimes.get(wordToLowerCase) + 1);
            } else {
                oddTimes.put(wordToLowerCase,1);
            }
        }


        List<String> oddValues = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : oddTimes.entrySet()) {
            if (entry.getValue() % 2 != 0){
                oddValues.add(entry.getKey());
            }
        }

        for (int i = 0; i < oddValues.size(); i++) {
            System.out.print(oddValues.get(i));
            if (i != oddValues.size() - 1){
                System.out.print(", ");
            }
        }

    }
}
