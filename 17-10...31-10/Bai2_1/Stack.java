package Bai2_1;

public class Stack {
    Node top;
    int size;

    public Stack() {
        top = null;
        size = 0; 
    }

    public void push(int element) {
        Node node = new Node();
        node.item = element;
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        int element = top.item;
        if (!isEmpty()) {
            top = top.next;
            size--;
        } else element = -1;
        return element;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public int numOfElement() {
        return size;
    }

    public void display() {
        if (top == null) {
            System.out.println("No element in this stack");
            return;
        }
        Node curNode = top;
        while (curNode.next != null) {
            System.out.print(curNode.item + " ");
            curNode = curNode.next;
        }
        System.out.println(curNode.item);
    }
}
