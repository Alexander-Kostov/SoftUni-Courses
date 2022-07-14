package ListsLab;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfProducts = Integer.parseInt(scanner.nextLine());

        List<String> allProducts = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            String product = scanner.nextLine();
            allProducts.add(product);
        }

        Collections.sort(allProducts);

        for (int i = 0; i < allProducts.size(); i++) {
            System.out.printf("%d.%s\n",i+1,allProducts.get(i));
        }
    }
}
