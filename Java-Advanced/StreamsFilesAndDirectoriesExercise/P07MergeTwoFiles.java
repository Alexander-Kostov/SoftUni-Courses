package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        Path input1 = Paths.get("04. Java-Advanced-Streams-Files-and-Directories-Resources/04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path input2 = Paths.get("04. Java-Advanced-Streams-Files-and-Directories-Resources/04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");

        Path output = Paths.get("output.txt");

        try {
            List<String> firstText = Files.readAllLines(input1);
            List<String> secondText = Files.readAllLines(input2);
            Files.write(output,firstText, StandardOpenOption.APPEND);
            Files.write(output,secondText, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
