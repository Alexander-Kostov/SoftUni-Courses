package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.ArrayList;

public class P10SerializeArrayList {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(5.2);
        list.add(3.4);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StreamsAndFilesResourcesLab/list.ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StreamsAndFilesResourcesLab/list.ser"))){
            oos.writeObject(list);
            Object listFromFile = ois.readObject();
            System.out.println(listFromFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
