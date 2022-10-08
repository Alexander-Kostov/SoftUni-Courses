package P06StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()){
            char firstChar = first.getName().toLowerCase().charAt(0);
            char secondChar = second.getName().toLowerCase().charAt(0);
            return Character.compare(firstChar,secondChar);
        }
        return Integer.compare(first.getName().length(),second.getName().length());
    }
}
