package FinalExam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    static class item {
        String name;
        String date;
        int calories;

        public item(String name, String date, int calories) {
            this.name = name;
            this.date = date;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([#|])(?<product>[A-Za-z ]+)\\1(?<date>[\\d]{2}\\/[\\d]{2}\\/[\\d]{2})\\1(?<calories>\\d{1,5})\\1";
        int sum = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<item> items = new ArrayList<>();

        while (matcher.find()) {
            String product = matcher.group("product");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            sum += calories;

            item a = new item(product,date,calories);
            items.add(a);
        }

        System.out.printf("You have food to last you for: %d days!\n", sum / 2000);
        for (item item : items) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n",item.getName(),item.getDate(),item.getCalories());
        }
    }
}
