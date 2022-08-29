package JavaAdvance.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteInBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            FileInputStream inputStream = new FileInputStream("input.txt");
            FileOutputStream outputStream = new FileOutputStream("output.txt");

            int read = inputStream.read();
            while (read != -1){
                String output = Integer.toBinaryString(read) + " ";
                for (char c : output.toCharArray()) {
                outputStream.write(c);
                }

                read = inputStream.read();
            }

        } catch (IOException ignore){

        }
    }
}
