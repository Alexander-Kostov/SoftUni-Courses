package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P01StudentInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double studentGrade = Double.parseDouble(scanner.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", studentName,age,studentGrade);
    }
}
