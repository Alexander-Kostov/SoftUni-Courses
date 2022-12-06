package InterfacesAndAbstractionExercise.P03BirthdayCelebrations;

public class Pet implements Birthable{

    private String name;
    private String birthDate;

    public Pet(String name, String birthDay) {
        this.name = name;
        this.birthDate = birthDay;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }
}
