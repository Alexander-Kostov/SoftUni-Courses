package DataTypesAndVariablesLab;

import java.util.Scanner;

public class P11RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double Length = Double.parseDouble(scanner.nextLine());

        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());

        System.out.print("Height: ");
        double Height = Double.parseDouble(scanner.nextLine());

        double Volume = ((Length * width * Height) / 3);

        System.out.printf("Pyramid Volume: %.2f", Volume);


    }
}
