import java.util.*;
public class RunningMedian {
    public class MinHeapComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a.compareTo(b) > 0) {
                return 1;
            } 
            else if (a.compareTo(b) < 0) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
    
    public class MaxHeapComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a.compareTo(b) > 0) {
                return -1;
            } 
            else if (a.compareTo(b) < 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    private MaxHeapComparator max;
    private MinHeapComparator min;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    public RunningMedian() {
        max = new MaxHeapComparator();
        min = new MinHeapComparator();
        maxHeap = new PriorityQueue<Integer>(11, max);
        minHeap = new PriorityQueue<Integer>(11, min);
    }

    public int peekMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return minHeap.peek();
        }
        
    }

    public int popMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.poll() + minHeap.poll()) / 2;
        }
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.poll();
        }
        else {
            return minHeap.poll();
        }
    }

    public void insert(int n) {
        if (maxHeap.size() == 0 || n < maxHeap.peek()) {
            maxHeap.add(n);
        }
        else {
            minHeap.add(n);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public boolean hasNextMedian() {
        return !(maxHeap.size() + minHeap.size() == 0);
    }

    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        rm.insert(100);
        rm.insert(13);
        rm.insert(76);
        rm.insert(79);
        rm.insert(82);
        while (rm.hasNextMedian()) {
            System.out.println(rm.popMedian());
        }
    }
}
