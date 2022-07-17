package GenericsExercise.GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add (T element){
        this.list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : this.list) {
            sb.append(String.format("%s: %s%n",t.getClass().getName(),t.toString()));
        }
        return sb.toString();
    }
}
