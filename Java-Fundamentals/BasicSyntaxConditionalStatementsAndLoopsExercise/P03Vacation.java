package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (dayOfWeek) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                }
                break;
            case "Business":
                if (groupOfPeople >= 100) {
                    groupOfPeople -= 10;
                }
                switch (dayOfWeek) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                }

                break;
            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                }
                break;
        }

        if (typeOfGroup.equals("Students") && groupOfPeople >= 30) {
            price = (price * groupOfPeople) * 0.85;
        } else if (typeOfGroup.equals("Regular") && groupOfPeople >= 10 && groupOfPeople <= 20) {
            price = (price * groupOfPeople) * 0.95;
        } else{
            price = price * groupOfPeople;
        }

        System.out.printf("Total price: %.2f", price);
    }
}
