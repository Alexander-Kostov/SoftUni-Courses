package DBAppsIntroductionExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P03GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSqlConnection();

        PreparedStatement villainSet = connection.prepareStatement(Statements.GET_VILLAIN_NAME_BY_ID_P03);

        Scanner scanner = new Scanner(System.in);
        int minion_id = scanner.nextInt();
        villainSet.setInt(1, minion_id);

        ResultSet villainResultSet = villainSet.executeQuery();

        if (!villainResultSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.%n", minion_id);
            return;
        }
        String villainName = villainResultSet.getString("name");

        System.out.println("Villain: " + villainName);

        int index = 1;

        PreparedStatement minionSet = connection.prepareStatement(Statements.GET_MINION_NAMES_P03);
        minionSet.setInt(1, minion_id);
        ResultSet minionResultSet = minionSet.executeQuery();

        while (minionResultSet.next()) {
            String minionName = minionResultSet.getString("name");
            int minionAge = minionResultSet.getInt("age");
            System.out.printf("%d. %s %d%n", index, minionName, minionAge);
            index++;
        }
        connection.close();

//        for (int index = 1; resultSet.next(); index++) {
//            final String minionName = resultSet.getString("m.name");
//            final int minionAge = resultSet.getInt("m.age");
//
//            System.out.printf("%d. %s %s%n", index, minionName, minionAge);
//
//        }


    }
}
