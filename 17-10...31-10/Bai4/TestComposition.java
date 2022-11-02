package Bai4;

public class TestComposition {
    public static void main(String[] args) {
        Graphic graphic = new Graphic();
        Shape p = new Point(1, 1);
        Shape c = new Circle((Point)p, 3);

        graphic.Add(p);
        graphic.Add(c);
        graphic.display();
    }
}
