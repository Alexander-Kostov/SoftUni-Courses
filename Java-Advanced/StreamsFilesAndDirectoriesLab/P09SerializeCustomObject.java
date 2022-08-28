package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class P09SerializeCustomObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "D:\\ChromeDownloads\\04.Java-Advanced-Streams-Files-and-Directories-Resources\\04" +
                ".Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\savedText.txt";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(cube);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
