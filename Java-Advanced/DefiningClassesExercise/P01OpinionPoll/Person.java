package JavaAdvance.DefiningClassesExercise.P01OpinionPoll;

public class Person {
    private String name;
    private int age;

    public void setAge(int age){
        this.age = age;
    }
    public void setName (String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

}
