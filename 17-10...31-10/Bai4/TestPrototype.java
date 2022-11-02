package Bai4;

public class TestPrototype {
    public static void main(String[] args) {
        Graphic g = new Graphic();

        Shape p1 = new Point(1, 1);
        Shape p2 = new Point((Point)p1);
        Shape p3 = p1.clone();

        g.Add(p1);
        g.Add(p2);
        g.Add(p3);

        g.display();
    }
}
