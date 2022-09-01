package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new FileReader("04. Java-Advanced-Streams-Files-and-Directories-Resources/04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/words.txt"));
            Scanner scannerForText = new Scanner(new FileReader("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. " +
                    "Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/text.txt"));
            PrintWriter printWriter = new PrintWriter("04. Java-Advanced-Streams-Files-and-Directories-Resources/04. " +
                    "Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/results.txt")){
            LinkedHashMap<String,Integer> words = new LinkedHashMap<>();
            Arrays.stream(scan.nextLine().split(" ")).forEach(word -> words.put(word,0));

            while (scannerForText.hasNext()){
                String word = scannerForText.next();
                if (words.containsKey(word)){
                    int occurrence = words.get(word);
                    occurrence++;
                    words.put(word,occurrence);
                }

            }

            words.entrySet().forEach(word -> printWriter.printf("%s - %d%n", word.getKey(),word.getValue()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
