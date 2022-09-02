package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("D:\\ChromeDownloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");


        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int totalSize = 0;
        while (!files.isEmpty()){
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()){
                    files.offer(nestedFile);
                }else {
                    totalSize += nestedFile.length();
                }
            }
        }
        System.out.println("Folder size: " + totalSize);

    }
}
