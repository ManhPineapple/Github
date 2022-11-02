package Bai4;

public class Circle extends Shape {
    Point center;
    int radius;

    public Circle(Point center, int radius) {
        this.id = cur_id;
        cur_id++;
        this.type = "Circle";
        this.center = center;
        this.radius = radius;
    }

    public Circle(Circle c) {
        this.id = cur_id;
        cur_id++;
        this.type = "Circle";
        this.center = c.center;
        this.radius = c.radius;
    }

    public void Operation() {

    }
    public void Add(Shape shape) {

    }
    public void Remove(Shape shape) {

    }
    public void GetChild(int i) {

    }
}
