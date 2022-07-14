package GenericsExercise.CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add (T element){
        this.list.add(element);
    }

    public T remove (int index){
        return this.list.remove(index);
    }

    public boolean contains (T element){
        return this.list.contains(element);
    }

    public void swap (int firstIndex, int secondIndex){
        T temp = list.get(firstIndex);
        list.set(firstIndex,list.get(secondIndex));
        list.set(secondIndex,temp);
    }

    public int countGreaterThan (T element){
        return (int)list.stream().filter(e -> e.compareTo(element) > 0).count();
    }
    public T getMax (){
        return list.stream().max(Comparator.naturalOrder()).get();
    }
    public T getMin (){
        return list.stream().min(Comparator.naturalOrder()).get();
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();

        for (T t : this.list) {
            sb.append(String.format("%s%n",t.toString()));
        }
        return sb.toString();
    }
}
