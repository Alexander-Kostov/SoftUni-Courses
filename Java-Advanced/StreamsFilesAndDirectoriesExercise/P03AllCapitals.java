package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter pw = new PrintWriter(new FileWriter("OutputForThirdTask.txt"))) {
            br.lines().forEach(l -> pw.println(l.toUpperCase()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
