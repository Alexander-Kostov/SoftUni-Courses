package JavaAdvance.DefiningClassesLab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> map = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String output = null;
            String[] data = input.split("\\s+");
            String command = data[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int key = bankAccount.getId();
                map.put(key, bankAccount);
                output = "Account ID" + key + " created";
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(data[1]);
                int amount = Integer.parseInt(data[2]);
                BankAccount bankAccount = map.get(id);
                if (bankAccount != null) {
                    bankAccount.deposit(amount);
                    output = "Deposited " + amount + " to ID" + id;
                } else {
                    output = "Account does not exist";
                }
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interest);
            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(data[1]);
                int years = Integer.parseInt(data[2]);
                BankAccount bankAccount = map.get(id);
                if (bankAccount != null) {
                    output = String.format("%.2f", bankAccount.getInterestRate(years));
                } else {
                    output = "Account does not exist";
                }
            }
            if (output != null){
            System.out.println(output);
            }

            input = scanner.nextLine();
        }
    }
}
