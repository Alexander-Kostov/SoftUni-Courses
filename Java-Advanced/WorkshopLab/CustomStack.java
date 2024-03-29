package JavaAdvance.WorkshopLab;

import java.util.function.Consumer;

public class CustomStack<E> {

    private static class Node<T> {
        private T element;
        private Node<T> prev;

        public Node (T element, Node prev){
            this.element = element;
            this.prev = prev;
        }
    }
    private Node<E> top;
    private int size;

    public CustomStack(){
    }


    public void push (E element){
        Node<E> newNode = new Node(element, this.top);
        this.top = newNode;
        size++;
    }

    public E pop (){
        ensureNotEmpty();
        E element = this.top.element;

        this.top = this.top.prev;

        this.size--;

        return element;
    }
    public E peek (){
        ensureNotEmpty();
        return this.top.element;
    }

    public void forEach (Consumer<E> consumer){
        Node<E> current = this.top;

        while (current != null){
            consumer.accept(current.element);
            current = current.prev;
        }
    }

    private void ensureNotEmpty(){
        if (this.top == null){
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }



}
