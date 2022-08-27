package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "input.txt";

        List<String> sortedLines = Files.readAllLines(Paths.get(path)).stream().sorted().collect(Collectors.toList());

        Path outputPath = Path.of("Output6.txt");
        Files.createFile(outputPath);

        Files.write(outputPath, sortedLines, StandardOpenOption.WRITE);
    }
}
