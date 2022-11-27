package InheritanceLab.P04RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("Alex");
        randomArrayList.add("Peter");
        randomArrayList.add("Michael");
        randomArrayList.add("John");
        randomArrayList.add("Steve");

        System.out.println(randomArrayList.getRandomElement());
    }
}
