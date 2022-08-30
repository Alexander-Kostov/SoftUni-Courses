package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P01SumLines {
    public static void main(String[] args) {

        try (BufferedReader bf = new BufferedReader(new FileReader("04. Java-Advanced-Streams-Files-and-Directories" +
                "-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"))) {
            String line = bf.readLine();

            while (line != null){
                int sum = 0;
                char [] chars = line.toCharArray();
                for (char aChar : chars) {
                    sum += aChar;
                }
                System.out.println(sum);

                line = bf.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
