package MidExam;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class training {

    // T e r z i e v
    // 0 1 2 3 4 5 6

    // -1 B
    // 7 B

    // if (index >= 0 && index < terziev.length){
    // Tersiahgihsaighasihgia
    // }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();


        String line = scanner.nextLine();

        while (!line.contains("Travel")) {
            String[] data = line.split(":");
            String command = data[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(data[1]);
                    String word = data[2];

                    if (index >= 0 && index < destination.length()){
                        String firstPart = destination.substring(0,index);
                        String secondPart = destination.substring(index,destination.length());

                        destination = firstPart + word + secondPart;
                        System.out.println(destination);

                    }

                        break;
                case "Remove Stop":
                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);

                    if (firstIndex >= 0 && firstIndex < destination.length()){
                        if (secondIndex >= 0 && secondIndex < destination.length()){
                            StringBuilder sb = new StringBuilder(destination);
                            sb.delete(firstIndex,secondIndex + 1);
                            destination = sb.toString();
                        }
                    }
                    System.out.println(destination);



                    break;
                case"Switch":

                    String oldString = data[1];
                    String newString = data[2];

                    while (destination.contains(oldString)){
                        destination = destination.replace(oldString,newString);
                    }

//                    if (destination.contains(oldString)){
//                        destination = destination.replaceAll(oldString,newString);
//                    }


//


                    System.out.println(destination);

                    break;
            }

            line = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s",destination);


    }
}





