package TextProcessingExercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();

        String file = filename.substring(filename.lastIndexOf("\\") + 1, filename.indexOf("."));
        String extension = filename.substring(filename.lastIndexOf(".") + 1);

        System.out.printf("File name: %s\n", file);
        System.out.printf("File extension: %s", extension);
    }
}
