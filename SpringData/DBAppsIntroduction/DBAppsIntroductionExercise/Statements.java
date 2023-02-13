package DBAppsIntroductionExercise;

public class Statements {
    static final String GET_VILLAINS_NAMES_P02 = "SELECT v.`name`, count(distinct minion_id) as number_of_minions FROM `villains` as v\n" +
            " JOIN minions_villains as mv ON v.id = mv.villain_id" +
            " GROUP BY mv.`villain_id`" +
            " HAVING number_of_minions > ?" +
            " ORDER BY number_of_minions DESC;";

    static final String GET_MINIONS_NAMES_P03 = "SELECT v.name, m.name, m.age FROM villains as v" +
            " JOIN minions_villains as mv ON v.id = mv.villain_id " +
            " JOIN minions as m ON m.id = mv.minion_id " +
            " WHERE v.id = ?;";


    static final String GET_VILLAIN_NAME_BY_ID_P03 = "SELECT name FROM villains WHERE id = ?";

    static final String GET_MINION_NAMES_P03 = "SELECT name, age FROM minions" +
            " JOIN minions_villains mv on minions.id = mv.minion_id" +
            " WHERE villain_id = ?;";

}
