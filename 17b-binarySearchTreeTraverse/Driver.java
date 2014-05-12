public class Driver {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(67);
        bst.insert(80);
        bst.insert(70);
        bst.insert(84);
        bst.insert(20);
        bst.insert(15);
        bst.insert(18);
        bst.insert(10);
        bst.traverse();
    }
}
