package DBAppsIntroductionExercise;

import jdk.jshell.execution.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P07PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSqlConnection();

        PreparedStatement minionsNameSet = connection.prepareStatement("SELECT name FROM minions");

        ResultSet minionsResultSet = minionsNameSet.executeQuery();

        List<String> allNames = new ArrayList<>();

        while (minionsResultSet.next()) {
            String name = minionsResultSet.getString("name");
            allNames.add(name);
        }

        int leftIndex = 0;
        int rightIndex = allNames.size() - 1;
        for (int i = 1; i <= allNames.size(); i++) {

            if (i % 2 != 0) {
                System.out.println(allNames.get(leftIndex));
                leftIndex++;
            } else {
                System.out.println(allNames.get(rightIndex));
                rightIndex--;
            }
        }

        connection.close();
    }
}
