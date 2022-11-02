package Bai7;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        Node n1 = new Node("*");
        Node n2 = new Node("+");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        t.push(n1, 1);
        t.push(n2, 2);
        t.push(n3, 3);
        t.push(n4, 4);
        t.push(n5, 5);

        // t.travelsal("Preorder", t.root);
        // t.travelsal("Inorder", t.root);
        // t.travelsal("Postorder", t.root);

        //System.out.println(t.calculate(t.root));
    }
}
