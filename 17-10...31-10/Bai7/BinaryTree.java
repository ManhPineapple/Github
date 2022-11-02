package Bai7;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void push(Node new_node, int pos) {
        if (pos == 1) {root = new_node; return; }

        Node curNode = root;
        String b_pos = Integer.toBinaryString(pos);
        for (int i = 1; i < b_pos.length() - 1; i++) {
            if (b_pos.charAt(i) == '0') {
                curNode = curNode.l_node;
            } else curNode = curNode.r_node;
        }

        if (b_pos.charAt(b_pos.length()-1) == '0') curNode.l_node = new_node;
            else curNode.r_node = new_node;
    }

    /**
     * Duyệt cây nhị phân
     * @param   order is "Preorder/Inorder/Postorder"
     * @param   curNode is root of the tree
     * @return  the result of tree travelsal
     */
    public void travelsal(String order, Node curNode) {
        if (order == "Preorder") {
            if (curNode == null) return;
            System.out.print(curNode.value + " ");
            travelsal(order, curNode.l_node);
            travelsal(order, curNode.r_node);
        }

        if (order == "Inorder") {
            if (curNode == null) return;
            travelsal(order, curNode.l_node);
            System.out.print(curNode.value + " ");
            travelsal(order, curNode.r_node);
        }

        if (order == "Postorder") {
            if (curNode == null) return;
            travelsal(order, curNode.l_node);
            travelsal(order, curNode.r_node);
            System.out.print(curNode.value + " ");
        } 
    }

    public int calculate(Node curNode) {
        if (curNode.value == "+") {
            int res = calculate(curNode.l_node) + calculate(curNode.r_node);
            curNode.value = Integer.toString(res);
            return res;
        }
        if (curNode.value == "-") {
            int res = calculate(curNode.l_node) - calculate(curNode.r_node);
            curNode.value = Integer.toString(res);
            return res;
        }
        if (curNode.value == "*") {
            int res = calculate(curNode.l_node) * calculate(curNode.r_node);
            curNode.value = Integer.toString(res);
            return res;
        }
        if (curNode.value == "/") {
            int res = calculate(curNode.l_node) / calculate(curNode.r_node);
            curNode.value = Integer.toString(res);
            return res;
        }
        return Integer.parseInt(curNode.value);
    }
}
