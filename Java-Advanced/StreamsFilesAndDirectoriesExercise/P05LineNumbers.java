package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P05LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {

        try(PrintWriter printWriter = new PrintWriter("output.txt")){

        Path inputFile = Paths.get("04. Java-Advanced-Streams-Files-and-Directories-Resources/04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(inputFile);

            for (int i = 0; i < lines.size(); i++) {
                printWriter.println(i + 1 + ". " + lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
