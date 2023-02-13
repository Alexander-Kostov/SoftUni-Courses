package DBAppsIntroductionExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String countryName = scanner.nextLine();

        Connection connection = Utils.getSqlConnection();

        PreparedStatement updateTownsByCountryStatement = connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");
        updateTownsByCountryStatement.setString(1, countryName);
        int count = updateTownsByCountryStatement.executeUpdate();

        if (count == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        List<String> towns = new ArrayList<>();

        System.out.println(count + " town names were affected.");

        PreparedStatement selectTownsByCountry = connection.prepareStatement("SELECT name FROM towns WHERE country = ?");
        selectTownsByCountry.setString(1, countryName);
        ResultSet townSet = selectTownsByCountry.executeQuery();
        while (townSet.next()) {
            String townName = townSet.getString("name");
            towns.add(townName);
        }
        System.out.print(towns);

        connection.close();

    }
}
