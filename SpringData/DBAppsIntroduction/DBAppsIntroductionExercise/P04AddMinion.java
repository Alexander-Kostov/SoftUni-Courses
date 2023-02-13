package DBAppsIntroductionExercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P04AddMinion {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String[] minionData = scanner.nextLine().split(" ");
        String[] villainData = scanner.nextLine().split(" ");

        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String townName = minionData[3];

        String villainName = villainData[1];

        Connection sqlConnection = Utils.getSqlConnection();


        PreparedStatement townStatement = sqlConnection.prepareStatement("SELECT id FROM towns WHERE name = ?");
        townStatement.setString(1, townName);

        ResultSet townSet = townStatement.executeQuery();

        int townID = 0;
        if (!townSet.next()) {
            PreparedStatement townInsertStatement = sqlConnection.prepareStatement("INSERT INTO towns(name) VALUES (?)");
            townInsertStatement.setString(1, townName);
            townInsertStatement.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", townName);
            townID = getTownId(townName, sqlConnection);
        }else {
            townID = getTownId(townName, sqlConnection);
        }
        PreparedStatement villainStatement = sqlConnection.prepareStatement("SELECT id FROM villains WHERE name = ?");
        villainStatement.setString(1, villainName);
        ResultSet villainSet = villainStatement.executeQuery();

        int villainID = 0;
        if (!villainSet.next()) {
            PreparedStatement insertVillainStatement = sqlConnection.prepareStatement
                    ("INSERT INTO villains (name, evilness_factor) VALUES(?, ?)");
            insertVillainStatement.setString(1, villainName);
            insertVillainStatement.setString(2, "evil");
            insertVillainStatement.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", villainName);

            villainID = getVillainID(villainName, sqlConnection);
        }else {
            villainID = getVillainID(villainName, sqlConnection);
        }

        PreparedStatement minionStatement = sqlConnection.prepareStatement("SELECT name FROM minions WHERE name = ?");
        minionStatement.setString(1, minionName);
        ResultSet minionSet = minionStatement.executeQuery();

        if (!minionSet.next()){
            PreparedStatement minionInsertStatement =
                    sqlConnection.prepareStatement("INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)");
            minionInsertStatement.setString(1, minionName);
            minionInsertStatement.setInt(2, minionAge);
            minionInsertStatement.setInt(3, townID);
            minionInsertStatement.executeUpdate();

            PreparedStatement getMinionId = sqlConnection.prepareStatement("SELECT id FROM minions WHERE name = ?");
            getMinionId.setString(1, minionName);
            ResultSet idMinionSet = getMinionId.executeQuery();
            idMinionSet.next();
            int minionID = idMinionSet.getInt("id");


            PreparedStatement insertMinionsVillains = sqlConnection.prepareStatement("INSERT INTO minions_villains VALUES (?, ?)");
            insertMinionsVillains.setInt(1, minionID);
            insertMinionsVillains.setInt(2, villainID);
            insertMinionsVillains.executeUpdate();
            System.out.printf("Successfully added %s to be minion of %s.%n", minionName,villainName);

        }

        sqlConnection.close();



    }

    private static int getVillainID(String villainName, Connection sqlConnection) throws SQLException {
        int villainID;
        PreparedStatement getVillainIDStatement =
                sqlConnection.prepareStatement("SELECT id FROM villains WHERE name = ?");
        getVillainIDStatement.setString(1, villainName);
        ResultSet villainIDSet = getVillainIDStatement.executeQuery();
        villainIDSet.next();
        villainID = villainIDSet.getInt("id");
        return villainID;
    }

    private static int getTownId(String townName, Connection sqlConnection) throws SQLException {
        int townID;
        PreparedStatement getTownIdStatement = sqlConnection.prepareStatement("SELECT id FROM towns WHERE name = ?");
        getTownIdStatement.setString(1, townName);
        ResultSet resultSet = getTownIdStatement.executeQuery();
        resultSet.next();
        townID = resultSet.getInt("id");
        return townID;
    }
}
