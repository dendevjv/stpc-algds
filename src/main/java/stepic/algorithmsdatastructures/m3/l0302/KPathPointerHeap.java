package stepic.algorithmsdatastructures.m3.l0302;

/**
 * Heap of sub-array pointers with a fixed capacity.
 */
public class KPathPointerHeap {
    private int size;
    private KPathPointer[] pointers;
    
    public KPathPointerHeap(int capacity) {
        pointers = new KPathPointer[capacity];
        size = 0;
    }
    
    public boolean isEmpty() { return size == 0; }
    
    public boolean isFull() { return size == pointers.length; }
    
    public KPathPointer getMin() {
        KPathPointer min = pointers[0];
        
        // move last to top
        int last = size - 1;
        if (last > 0) {
            pointers[0] = pointers[last];
            siftDown(0);
        }
        size--;
        
        return min;
    }

    public void add(KPathPointer p) {
        if (size == pointers.length) {
            throw new IllegalStateException("This instance of pointer heap is full, cannot add any pointers");
        }
        
        pointers[size] = p;
        size++;
        siftUp(size - 1);
    }

    private void siftDown(int i) {
        int left = i * 2 + 1;
        if (left < size) {
            int lesser = left;
            int right = i * 2 + 2;
            if (right < size) {
                if (pointers[right].compareTo(pointers[left]) < 0) {
                    lesser = right;
                }
            }
            if (pointers[i].compareTo(pointers[lesser]) > 0) {
                swap(i, lesser);
                siftDown(lesser);
            }
        }
    }
    
    private void swap(int i, int j) {
        KPathPointer tmp = pointers[j];
        pointers[j] = pointers[i];
        pointers[i] = tmp;
    }

    private void siftUp(int i) {
        int p = (i - 1) / 2;
        if (p >= 0) {
            if (pointers[p].compareTo(pointers[i]) > 0) {
                swap(p, i);
                if (p > 0) {
                    siftUp(p);
                }
            }
        }
    }
}
