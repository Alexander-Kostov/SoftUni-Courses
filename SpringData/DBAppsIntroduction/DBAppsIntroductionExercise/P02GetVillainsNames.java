package DBAppsIntroductionExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P02GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSqlConnection();

        final PreparedStatement preparedStatement = sqlConnection.prepareStatement(Statements.GET_VILLAINS_NAMES_P02);
        preparedStatement.setInt(1, 15);
        final ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int minionsCount = resultSet.getInt("number_of_minions");

            System.out.printf("%s %d%n", minionName, minionsCount);
        }


    }
}
