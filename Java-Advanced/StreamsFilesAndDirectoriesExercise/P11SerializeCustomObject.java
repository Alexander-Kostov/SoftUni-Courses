package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.Scanner;

public class P11SerializeCustomObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course course = new Course();
        course.name = "java";
        course.students = 250;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("04. Java-Advanced-Streams-Files-and-Directories-Resources/04." +
                " Java-Advanced-Files-and-Streams-Exercises-Resources/course.ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("04. Java-Advanced-Streams-Files-and-Directories-Resources/04." +
                    " Java-Advanced-Files-and-Streams-Exercises-Resources/course.ser"))) {
            oos.writeObject(course);
            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
