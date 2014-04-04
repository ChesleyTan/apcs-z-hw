public class MyStack {
    private Node top;
    private int numElements = 0;
      
    // constructor
    public MyStack() {
        top = null;
    }

    // push 2
    public void push(String s) {
        Node tmp = new Node(s);
        tmp.setNext(top);
        top = tmp;
        numElements++;
    }

    // pop
    public String pop() {
        String s = top.getData();
        top = top.getNext();
        numElements--;
        return s;
    }
    
    // peek
    public String peek() {
        return top.getData();
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    // toString
    public String toString() {
        String s = "";
        for (Node tmp = top;tmp != null;tmp = tmp.getNext()) {
            s += tmp.getData() + ", ";    
        }
        return s;
    }

    public int size() {
        return numElements;
    }
}
