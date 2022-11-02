package Bai4;

public class Rectangle extends Shape {
    Point p1, p2, p3, p4;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.id = cur_id;
        cur_id++;
        this.type = "Rectangle";
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Rectangle(Rectangle r) {
        this.id = cur_id;
        cur_id++;
        this.type = "Rectangle";
        this.p1 = r.p1;
        this.p2 = r.p2;
        this.p3 = r.p3;
        this.p4 = r.p4;
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
