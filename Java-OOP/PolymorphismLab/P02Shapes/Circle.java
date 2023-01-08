package PolymorphismLab.P02Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        setArea(calculateArea());
        setPerimeter(calculatePerimeter());
    }


    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }

    public final Double getRadius() {
        return radius;
    }
}
