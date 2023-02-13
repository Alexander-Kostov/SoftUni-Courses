package DBAppsIntroductionExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06RemoveVillain {
    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getSqlConnection();

        Scanner scanner = new Scanner(System.in);


        int villainID = scanner.nextInt();

        PreparedStatement villainStatement = connection.prepareStatement("SELECT name FROM villains WHERE id = ?");
        villainStatement.setInt(1, villainID);
        ResultSet villainSet = villainStatement.executeQuery();

        if (!villainSet.next()) {
            System.out.println("No such villain was found");
        }

        String villainName = villainSet.getString("name");

        PreparedStatement selectCountMinionsStatement = connection.prepareStatement("SELECT COUNT(minion_id) as minions_count FROM minions_villains" +
                " WHERE villain_id = ?");

        selectCountMinionsStatement.setInt(1,villainID);

        ResultSet countMinionsResultSet = selectCountMinionsStatement.executeQuery();
        countMinionsResultSet.next();
        int count = countMinionsResultSet.getInt("minions_count");

        try {
            PreparedStatement deletedMinionsVillains = connection.
                    prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?;");
            deletedMinionsVillains.setInt(1, villainID);
            deletedMinionsVillains.executeUpdate();

            PreparedStatement deletedVillain = connection.prepareStatement("DELETE FROM villains WHERE id = ?");
            deletedVillain.setInt(1, villainID);
            deletedVillain.executeUpdate();

            System.out.printf("%s was deleted%n",villainName);
            System.out.printf("%d minions released%n", count);

            System.out.println();
        } catch (SQLException e){
            connection.rollback();
        }
    }
}
