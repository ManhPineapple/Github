package Bai4;

import java.util.ArrayList;
import java.util.List;

public class Graphic extends Shape {
    List<Shape> listOfShape;

    public Graphic() {
        listOfShape = new ArrayList<>();
    }

    public void Operation() {

    }

    public void Add(Shape shape) {
        listOfShape.add(shape);
    }

    public void Remove(Shape shape) {
        listOfShape.remove(shape);
    }
    
    public void GetChild(int i) {

    }

    public void display() {
        for (Shape shape : listOfShape) {
            System.out.println(shape.type + " Id:" + shape.id);
        }
    }
}
