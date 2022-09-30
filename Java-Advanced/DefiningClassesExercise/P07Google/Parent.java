package JavaAdvance.DefiningClassesExercise.P07Google;

public class Parent {
    String parentName;
    String parentBirthday;

    public Parent (String parentName, String parentBirthday){
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }


    @Override
    public String toString() {
        return String.format("%s %s",parentName, parentBirthday);
    }
}
