package football;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private FootballTeam footballTeam;
    private Footballer footballer;

    @Before
    public void setup() {
        footballTeam = new FootballTeam("Test", 2);
        footballer = new Footballer("Gosho");
        footballTeam.addFootballer(footballer);
    }

    @Test(expected = NullPointerException.class)
    public void checkEmptyNameForFootballTeam() {
        footballTeam = new FootballTeam(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkForNegativeVacantPositions() {
        footballTeam = new FootballTeam("Test", -5);
    }

    @Test
    public void getVacantPositions() {
        int actual = footballTeam.getVacantPositions();
        Assert.assertEquals(2, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFootballerToFullTeam() {
        Footballer gosho = new Footballer("Gosho");
        Footballer tosho = new Footballer("Tosho");

        footballTeam.addFootballer(gosho);
        footballTeam.addFootballer(tosho);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingFootballer() {
        footballTeam.removeFootballer("alexi");
    }

    @Test
    public void removeExistingFootballer() {
        footballTeam.removeFootballer("Gosho");
        int count = footballTeam.getCount();

        Assert.assertEquals(0, count);
    }

    @Test
    public void saleExistingFootballer() {
        Footballer footballer = footballTeam.footballerForSale("Gosho");
        Assert.assertEquals("Gosho", footballer.getName());
        Assert.assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void saleNonExistingFootballer() {
        Footballer footballer = footballTeam.footballerForSale("Tosho");
    }

    @Test
    public void checkStatistics() {
        String expected = "The footballer Gosho is in the team Test.";
        Assert.assertEquals(expected, footballTeam.getStatistics());
    }

}
