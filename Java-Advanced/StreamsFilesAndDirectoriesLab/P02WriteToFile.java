package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Character> table = Set.of(',' , '.', '!', '?');
        String path = "input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            FileOutputStream outputStream = new FileOutputStream("Output2.txt");

            int read = inputStream.read();

            while (read != -1) {
                if(!table.contains((char) read)){
                    outputStream.write(read);
                }

                read = inputStream.read();
            }

        } catch (IOException ignore) {

        }
    }
}
