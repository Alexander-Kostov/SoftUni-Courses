package RegularExperssionsExercise;

import java.util.Scanner;

public class softuni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cast = scanner.nextLine();
        String input = scanner.nextLine();

        while(!input.equals("Abracadabra")){
            String[]data = input.split(" ");
            String command = data[0];
            switch(command){
                case"Abjuration":
                    String Upper = cast.replace(cast, cast.toUpperCase());
                    System.out.println(Upper);
                    cast = Upper;
                    break;

                case"Necromancy":
                    String lower = cast.replace(cast, cast.toLowerCase());
                    System.out.println(lower);
                    cast = lower;
                    break;
                case"Illusion":
                    int index = Integer.parseInt(data[1]);
                    String letter = data[2];
                    if(index>=0 && index<cast.length()){
                        String firstString =cast.substring(0,index);
                        String secondString =cast.substring(index+1);
                        String combined = firstString + letter+ secondString;
                        cast = combined;
                        System.out.println("Done!");
                    }else{
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case"Divination":
                    String firstSubString = data[1];
                    String secondSubString = data[2];
                    String replace = cast.replace(firstSubString, secondSubString);
                    if(!replace.equals(cast)){
                        cast = replace;
                        System.out.println(cast);
                    }
                    break;

                case"Alteration":
                    String substring = data[1];
                    String replacedSubstring = cast.replace(substring, "");

                    if(!replacedSubstring.equals(cast)){
                        cast = replacedSubstring;
                        System.out.println(cast);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
                    break;

            }



            input = scanner.nextLine();
        }

    }
}
