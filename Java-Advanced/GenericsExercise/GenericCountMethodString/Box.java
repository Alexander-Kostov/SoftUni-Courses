package GenericsExercise.GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>> {
    private List<T> list;

    public Box(){
        this.list = new ArrayList<>();
    }

    public void add (T element){
        this.list.add(element);
    }

    public long countGreaterThan (T element){
        return this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : this.list) {
            sb.append(String.format("%s: %s",t.getClass().getName(),t));
        }
        return sb.toString();
    }
}
