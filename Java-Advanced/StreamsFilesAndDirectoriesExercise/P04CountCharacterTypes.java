package JavaAdvance.StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Streams-Files-and-Directories-Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        try(FileReader fileReader = new FileReader(path);
            PrintWriter printWriter = new PrintWriter(new FileWriter("CountCharacters.txt"))) {
            int read = fileReader.read();
            while (read != -1){
                char element = (char) read;
                if (element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u'){
                    vowels++;
                }else if (element == '?' || element == '.' || element == ',' || element == '!'){
                    punctuation++;
                }else if (!Character.isWhitespace(element)){
                    consonants++;
                }
                read = fileReader.read();
            }
            printWriter.println("Vowels: " + vowels);
            printWriter.println("Consonants: " + consonants);
            printWriter.println("Punctuation: " + punctuation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
