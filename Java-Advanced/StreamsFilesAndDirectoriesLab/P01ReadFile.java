package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "StreamsAndFilesResourcesLab/input.txt";

        try(FileInputStream inputStream = new FileInputStream(path)) {
            int read = inputStream.read();

            while (read != -1){
                System.out.print(Integer.toBinaryString(read) + " ");
                read = inputStream.read();
            }
        } catch (IOException ignored){

        }
    }
}
