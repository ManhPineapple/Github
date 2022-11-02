package Bai4;

public abstract class Shape implements Cloneable {
    static int cur_id = 1;
    int id;
    String type;

    public abstract void Operation();
    public abstract void Add(Shape shape);
    public abstract void Remove(Shape shape);
    public abstract void GetChild(int i);

    public Shape clone() {
        Shape clone = null;
        try {
            clone = (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
