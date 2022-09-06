package JavaAdvance.WorkshopExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int number) {
        Node newNode = new Node(number);
        if (!isEmpty()) {
            newNode.next = this.head;
            head.prev = newNode;
        } else {
            this.tail = newNode;
        }

        this.head = newNode;
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list.");
        }
        int value = this.head.value;

        this.head = this.head.next;
        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        } else {
            head.prev = null;
        }

        return value;
    }

    public void addLast(int number) {
        if (isEmpty()) {
            addFirst(number);
            return;
        }
        Node newNode = new Node(number);


        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }


        int result = tail.value;
        tail = tail.prev;
        tail.next = null;
        size--;
        return result;
    }

    public int get(int index) {
        validateIndex(index);
        if (index <= size / 2) {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            return currentNode.value;
        } else {
            Node currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            return currentNode.value;
        }

    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;

        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        forEach(list::add);
        return list.stream().mapToInt(e -> e).toArray();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
    }


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
