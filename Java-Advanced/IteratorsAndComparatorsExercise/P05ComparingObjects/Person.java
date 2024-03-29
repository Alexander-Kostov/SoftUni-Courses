package P05ComparingObjects;

public class Person implements Comparable<Person> {
    String name;
    int age;
    String town;

    public Person (String name, int age, String town){
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getName().equals(other.getName())){
            if (this.getAge() == other.getAge()){
                return this.getTown().compareTo(other.getTown());
            }
            return Integer.compare(this.getAge(),other.getAge());
        }
        return this.name.compareTo(other.getName());
    }
}
