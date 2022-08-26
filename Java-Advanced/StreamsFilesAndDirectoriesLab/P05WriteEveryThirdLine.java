package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "input.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        BufferedWriter writer = new BufferedWriter(new FileWriter("Output5.txt"));

        String line = reader.readLine();

        int counter = 0;
        while (line != null){
            counter++;
            if (counter % 3 == 0){
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
        }
        writer.close();
        reader.close();


    }
}
