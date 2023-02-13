package DBAppsIntroductionExercise;

import java.sql.*;
import java.util.Scanner;


public class P08IncreaseMinionAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);


        String iDS = String.join(", ", scanner.nextLine().split("\\s+"));

        Connection connection = Utils.getSqlConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE minions SET age = age + 1," +
                " name = lower(name) WHERE id IN(" + iDS + ")");

        preparedStatement.executeUpdate();

        PreparedStatement allMinionsStatement = connection.prepareStatement("SELECT name, age FROM minions");

        ResultSet resultSet = allMinionsStatement.executeQuery();

        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.printf("%s %d%n", minionName, age);
        }

    }
}
