package Bai4;

public class Line extends Shape {
    Point p1, p2;

    public Line(Point p1, Point p2) {
        this.id = cur_id;
        cur_id++;
        this.type = "Line";
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(Line l) {
        this.id = cur_id;
        cur_id++;
        this.type = "Line";
        this.p1 = l.p1;
        this.p2 = l.p2;
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
