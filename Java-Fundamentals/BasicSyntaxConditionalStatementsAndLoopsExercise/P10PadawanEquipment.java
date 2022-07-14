package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyOfLucas = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double swordsPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double studentsForSword = Math.ceil(students * 1.10);
        double studentsSwordPrice = studentsForSword * swordsPrice;
        double studentsRobesPrice = students * robesPrice;
        double studentsBeltPrice = students * beltsPrice;
        for (int i = 6; i <= students; i+=6) {
            studentsBeltPrice -= beltsPrice;
        }

        double sumAllPrice = studentsSwordPrice + studentsRobesPrice + studentsBeltPrice;

        if (sumAllPrice <= moneyOfLucas) {
            System.out.printf("The money is enough - it would cost %.2flv.",sumAllPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.",Math.abs(sumAllPrice - moneyOfLucas));
        }
    }
}
