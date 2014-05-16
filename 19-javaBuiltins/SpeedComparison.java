import java.util.*;
public class SpeedComparison {
    private HashMap<Integer, String> hashMap;
    private TreeMap<Integer, String> treeMap;

    public SpeedComparison() {
        hashMap = new HashMap();
        treeMap = new TreeMap();
    }

    public long inputH(int i) {
        long start = System.nanoTime();
        for (;i > 0;i--) {
            hashMap.put(i, "hello world");
        }
        return System.nanoTime() - start;
    }
    
    public long inputT(int i) {
        long start = System.nanoTime();
        for (;i > 0;i--) {
            treeMap.put(i, "hello world");
        }
        return System.nanoTime() - start;
    }

    public long removeH(int i) {
        long start = System.nanoTime();
        for (;i > 0;i--) {
            hashMap.remove(i);
        }
        return System.nanoTime() - start;
    }

    public long removeT(int i) {
        long start = System.nanoTime();
        for (;i > 0;i--) {
            treeMap.remove(i);
        }
        return System.nanoTime() - start;
    }

    public void clearAll() {
        hashMap.clear();
        treeMap.clear();
    }

    public static void main(String[] args) {
        SpeedComparison sc = new SpeedComparison();
        int size = 100000;
        System.out.println("HashMap put runtime: " + sc.inputH(size));
        System.out.println("TreeMap put runtime: " + sc.inputT(size));
        System.out.println("HashMap remove runtime: " + sc.removeH(size));
        System.out.println("TreeMap remove runtime: " + sc.removeT(size));
    }
}
