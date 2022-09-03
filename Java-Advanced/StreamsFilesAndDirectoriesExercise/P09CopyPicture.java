package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyPicture {
    public static void main(String[] args) {

        byte [] buffer = new byte[1024];

        try(FileInputStream fis = new FileInputStream("dc-batman.jpg");
            FileOutputStream fos = new FileOutputStream("NewImage.jpg")) {
            while (fis.read(buffer) != -1){
                fos.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
