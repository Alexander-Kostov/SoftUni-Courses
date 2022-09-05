package JavaAdvance.WorkshopLab;

import java.util.function.Consumer;

public class SmartArray<E> {
    private Object[] data;
    private int size;

    public SmartArray() {
        this.data = new Object[4];
        this.size = 0;
    }

    public void add(E element) {
        if (this.size == this.data.length){
            this.data = grow();
        }
        this.data[size] = element;
        size++;
    }

    public E remove (int index){
        validateIndex(index);

        E element = get(index);

        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = null;

        this.size--;
        if (this.data.length / 4 >= this.size || this.data.length / 4 == 4) {
            this.data = shrink();
        }
        return element;
    }
    @SuppressWarnings("unchecked")

    public E get (int index){
        validateIndex(index);
        return (E) this.data[index];
    }
    
    public boolean contains(int element){
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public void add (int index, E element){
        validateIndex(index);

        int lastIndex = this.size - 1;
        E lastElement = get(lastIndex);

        for (int i = lastIndex; i > index ; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = element;
        add(lastElement);

    }

    public void forEach (Consumer<E> consumer) {
        for (int i = 0; i < this.data.length; i++) {
            E e = get(i);
            consumer.accept(e);
        }
    }


    public int size (){
        return this.size;
    }

    private Object[] grow() {
       Object [] temp = new Object[this.data.length * 2];

        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];

        }

        return temp;
    }

    private Object[] shrink() {
        Object [] temp = new Object[this.data.length / 2];

        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];

        }

        return temp;
    }
    private void validateIndex(int index) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("invalid index");
        }
    }

}
