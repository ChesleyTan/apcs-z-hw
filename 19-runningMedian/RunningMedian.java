public class RunningMedian {
    private MaxHeap maxHeap;
    private MinHeap minHeap;
    
    public RunningMedian() {
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();
    }

    public int getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.get() + minHeap.get()) / 2;
        }
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.get();
        }
        else {
            return minHeap.get();
        }
        
    }

    public int popMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.remove() + minHeap.remove()) / 2;
        }
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.remove();
        }
        else {
            return minHeap.remove();
        }
    }

    public void insert(int n) {
        if (maxHeap.size() == 0 || n < maxHeap.get()) {
            maxHeap.insert(n);
        }
        else {
            minHeap.insert(n);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.insert(maxHeap.remove());
        }
        else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.insert(minHeap.remove());
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
