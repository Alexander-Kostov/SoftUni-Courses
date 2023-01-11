package WorkingWithAbstractionLab.P02PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterThanOrEqual (Point other){
        return x >= other.x && y >= other.y;
    }

    public boolean isLessOrEqual (Point other) {
        return x <= other.x && y <= other.y;
    }
}
