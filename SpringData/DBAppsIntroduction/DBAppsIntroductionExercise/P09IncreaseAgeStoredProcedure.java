package DBAppsIntroductionExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P09IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getSqlConnection();

        Scanner scanner = new Scanner(System.in);

        int minion_id = scanner.nextInt();

        PreparedStatement updateStatement = connection.prepareStatement("CALL usp_get_older(?)");
        updateStatement.setInt(1,minion_id);
        updateStatement.executeUpdate();

        PreparedStatement selectStatement = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        selectStatement.setInt(1, minion_id);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        String minionName = resultSet.getString("name");
        int minionAge = resultSet.getInt("age");

        System.out.println(minionName + " " + minionAge);


    }
}
