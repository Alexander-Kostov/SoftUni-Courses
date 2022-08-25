package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P03CopyToBytes {
    public static void main(String[] args) {

        String path = "input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("Output3.txt");

            PrintWriter printWriter = new PrintWriter(fileOutputStream);

            int read = fileInputStream.read();
            while (read != -1) {
                if (read == ' ') {
                    printWriter.print(' ');
                } else if (read == 10) {
                    printWriter.println();
                } else {
                    printWriter.print(read);
                }
                read = fileInputStream.read();
            }
            printWriter.close();
        } catch (IOException ignore) {

        }

    }
}
