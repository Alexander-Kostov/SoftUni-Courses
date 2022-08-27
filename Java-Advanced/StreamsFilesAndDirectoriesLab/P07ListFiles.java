package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {
        File root = new File("D:\\ChromeDownloads\\04.Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                "Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");


        Arrays.stream(root.listFiles()).filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": " + "[" + f.length() + "]"));
    }
}
