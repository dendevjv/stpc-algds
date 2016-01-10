package stepic.algorithmsdatastructures.m2.l0202;

public class PriorityQueue {
    private static final int INITIAL_CAPACITY = 1;
    private int size;
    private int[] data;
    
    public PriorityQueue() {
        data = new int[INITIAL_CAPACITY];
    }
    
    public PriorityQueue(int[] values) {
        data = new int[values.length];
        for (int v : values) {
            add(v);
        }
    }
    
    public void add(int v) {
        ensureCapacity(size + 1);
        if (size > 0) {
            int i = size;
            data[i] = v;
            siftUp(i);
        } else {
            data[0] = v;
        }
        size++;
    }
    
    public int getNext() {
        int next = data[0];
        if (size > 1) {
            int last = data[size - 1];
            data[0] = last;
            siftDown(0);
        }
        size--;
        return next;
    }
    
    public int peekNext() {
        return data[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int i) {
        int p = (i - 1) / 2;
        if (p >= 0) {
            if (data[p] < data[i]) {
                swap(p, i);
                siftUp(p);
            }
        }
    }
    
    private void siftDown(int i) {
        int left = i * 2 + 1;
        if (left < size) {
            int greater = left;
            int right = i * 2 + 2;
            if (right < size && data[left] < data[right]) {
                greater = right;
            }
            if (data[i] < data[greater]) {
                swap(i, greater);
                siftDown(greater);
            }
        }
    }

    private void swap(int p, int i) {
        int tmp = data[p];
        data[p] = data[i];
        data[i] = tmp;
    }
    
    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            data = java.util.Arrays.copyOf(data, data.length * 2);
        }
    }
}
