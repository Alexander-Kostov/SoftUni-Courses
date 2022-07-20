package GenericsExercise.GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box (){
        this.values = new ArrayList<>();
    }

    public void add (T element) {
        this.values.add(element);
    }

    public void swap (int firstIndex, int secondIndex){
        T temp = values.get(firstIndex);
        this.values.set(firstIndex,values.get(secondIndex));
        this.values.set(secondIndex,temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : this.values) {
            sb.append(String.format("%s: %s%n",value.getClass().getName(),value));
        }
        return sb.toString();
    }
}
