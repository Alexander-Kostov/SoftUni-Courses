package DBAppsIntroductionLab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class P02DataRetrievalApplication {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        username = username.equals("") ? "root" : username;

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        PreparedStatement prep = connection.prepareStatement(
                " SELECT `user_name`, `first_name`, `last_name`, (SELECT count(*) FROM `users_games` WHERE u.`id` = users_games.`user_id`) as cd " +
                        " FROM `users` as u " +
                        " WHERE `user_name` = ?");

        String user = scanner.nextLine();
        prep.setString(1,user);
        ResultSet resultSet = prep.executeQuery();

        if (resultSet.next()) {
            System.out.println("User: " + resultSet.getString("user_name"));
            System.out.println(resultSet.getString("first_name") + " " +
                    resultSet.getString("last_name") + " has played " + resultSet.getInt("cd")
                    + " games");
        }else {
            System.out.println("No such user exists");
        }

    }
}
