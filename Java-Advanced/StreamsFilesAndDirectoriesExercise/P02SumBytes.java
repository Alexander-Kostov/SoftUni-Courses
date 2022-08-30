package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                char[] chars = line.toCharArray();

                for (char aChar : chars) {
                    sum += aChar;
                }

                line = br.readLine();
            }
        }
        System.out.println(sum);


    }
}
