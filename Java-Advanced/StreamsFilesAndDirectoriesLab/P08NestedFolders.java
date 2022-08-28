package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File file = new File("D:\\ChromeDownloads\\04.Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        PrintStream out = new PrintStream("D:\\ChromeDownloads\\04.Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\nestedFiles.txt");


        ArrayDeque<File> stack = new ArrayDeque<>();
        int counter = 0;
        stack.push(file);
        while (!stack.isEmpty()) {
            File current = stack.poll();
            if (current.isDirectory()) {
                out.println(current.getName());
                counter++;
                for (File file1 : current.listFiles()) {
                    stack.offer(file1);
                }
            }
        }
        out.printf("%d folders", counter);

    }
}
