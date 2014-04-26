public class Driver {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(50);
        System.out.println(bst.search(1));
        System.out.println(bst.search(100));
        System.out.println(bst.search2(1));
        System.out.println(bst.search2(100));
    }
}
