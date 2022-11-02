package Bai4;

public class Point extends Shape {
    int x, y;

    public Point(int x, int y) {
        this.id = cur_id;
        cur_id++;
        this.type = "Point";
        this.x = x;
        this.y = y;
    }
    
    public Point(Point p) {
        this.id = cur_id;
        cur_id++;
        this.type = "Point";
        this.x = p.x;
        this.y = p.y;
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
