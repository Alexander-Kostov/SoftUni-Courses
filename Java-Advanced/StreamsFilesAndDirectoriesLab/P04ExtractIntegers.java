package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(fileInputStream);

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("Output4.txt"));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                printWriter.println(scanner.next());
            }else {
                scanner.next();
            }
        }

        printWriter.close();
    }
}
