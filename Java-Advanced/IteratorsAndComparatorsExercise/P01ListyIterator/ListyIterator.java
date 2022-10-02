package IteratorsComparatorsExerciseP01ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListyIterator (String... elements){
        this.list = Arrays.asList(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext () {
       return currentIndex < list.size() - 1;
    }

    public boolean move () {
        if (hasNext()){
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public void print () {
        if (this.list.isEmpty()){
            throw new IllegalStateException("Invalid Operation");
        }
        System.out.println(this.list.get(currentIndex));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public String next() {
                String element = list.get(index);
                index++;
                return element;
            }
        };
    }
}
