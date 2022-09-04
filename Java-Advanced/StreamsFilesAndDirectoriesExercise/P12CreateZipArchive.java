package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) {
        List<String> filePaths = Arrays.asList("D:\\SoftUni\\Java Advance\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt", "D:\\SoftUni\\Java Advance\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt", "D:\\SoftUni\\Java Advance\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        String zipPath = "ZipFile.zip";

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (String filePath : filePaths) {
                File fileToZip = new File(filePath);
                zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                Files.copy(fileToZip.toPath(), zipOut);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
