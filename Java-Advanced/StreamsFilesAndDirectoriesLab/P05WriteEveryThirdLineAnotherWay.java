package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class P05WriteEveryThirdLineAnotherWay {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "input.txt";

        List<String> strings = Files.readAllLines(Paths.get(path));

        for (int i = 2; i < strings.size() ; i+=3) {
            System.out.println(strings.get(i));
        }
    }
}
