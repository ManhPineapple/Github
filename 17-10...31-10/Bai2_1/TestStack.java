package Bai2_1;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        //stack.push(1);
        //stack.push(2);
        //stack.pop();
        //stack.push(3); 
        //stack.pop();
        //stack.pop();

        if (!stack.isEmpty()) {
            System.out.println(stack.numOfElement());
        }
        else System.out.println("0");

        stack.display(); 
    }
}
