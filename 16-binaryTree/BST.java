public class BST {
    private Node root;

    public Node search(int x) {
        Node tmp = root;
        while (tmp != null && tmp.getData() != x) {
            if (tmp.getData() < x) {
                tmp = tmp.getLeft();
            }
            else {
                tmp = tmp.getRight();
            }
        }
        return tmp;
    }

    public void insert(int x) {
        Node newNode = new Node(x);
        if (root == null) {
            root = newNode;
            return;
        }
        Node prev = null;
        Node curr = root;
        while (curr != null) {
            prev = curr;
            if (curr.getData() < x) {
                curr = curr.getLeft();
            }
            else {
                curr = curr.getRight();
            }
        }
        if (prev.getData() < x) {
            prev.setLeft(newNode);
        }
        else {
            prev.setRight(newNode);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(20);
        bst.insert(30);
        bst.insert(10);
    }
}
