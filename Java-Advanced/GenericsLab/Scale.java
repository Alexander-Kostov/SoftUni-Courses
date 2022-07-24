package GenericsLab;

public class Scale<T extends Comparable<T>> {
    private T right;
    private T left;

    public Scale(T right, T left) {
        this.right = right;
        this.left = left;
    }

    public T getHeavier() {
        if (left.compareTo(right) > 0) {
            return left;
        }else if (right.compareTo(left) > 0){
            return right;
        }else {
            return null;
        }
    }
}
