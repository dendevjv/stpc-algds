package stepic.algorithmsdatastructures.m2.l0201;

public class ArrayDequeInt {
    private static final int NON_EXISTING_VALUE = -1;

    private static final int DEFAULT_CAPACITY = 2;
    
    private int[] buffer;
    /** Index of first element */
    private int head;
    /** Index of the element after the last element */
    private int tail;
    private int size;
    
    public ArrayDequeInt() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayDequeInt(int initialCapacity) {
        buffer = new int[initialCapacity];
        size = 0;
    }
    
    public void pushFront(int v) {
        ensureCapacity(size + 1);
        head--;
        head = (head < 0) ? (buffer.length - 1) : head;
        buffer[head] = v;
        size++;
    }
    
    private void ensureCapacity(int capacity) {
        if (capacity > buffer.length) {
            int[] newBuffer = new int[buffer.length * 2];
            int p = head;
            for (int i = 0; i < size; i++) {
                newBuffer[i] = buffer[p];
                p = (p + 1) % buffer.length;
            }
            buffer = newBuffer;
            head = 0;
            tail = size;
        }
    }

    public int popFront() {
        if (size == 0) {
            return NON_EXISTING_VALUE;
        }
        int value = buffer[head];
        head = (head + 1) % buffer.length;
        size--;
        return value;
    }
    
    public void pushBack(int v) {
        ensureCapacity(size + 1);
        buffer[tail] = v;
        tail = (tail + 1) % buffer.length;
        size++;
    }
    
    public int popBack() {
        if (size == 0) {
            return NON_EXISTING_VALUE;
        }
        int idx = (tail - 1);
        idx = (idx < 0) ? (buffer.length - 1) : idx;
        int value = buffer[idx];
        tail = idx;
        size--;
        return value;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        int current = head;
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(buffer[current]);
            current = (current + 1) % buffer.length;
        }
        sb.append(']');
        return sb.toString();
    }
}
