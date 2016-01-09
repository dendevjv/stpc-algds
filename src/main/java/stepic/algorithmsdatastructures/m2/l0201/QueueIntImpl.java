package stepic.algorithmsdatastructures.m2.l0201;

public class QueueIntImpl implements QueueInt {
    private static final boolean LOGGING = true;
    
    /** Index of the first queue element. */
    private int head;
    /** Index of the element after the last queue element. */
    private int tail;
    private int[] buffer;
    /** Number of elements in the queue. */
    private int size;
    
    public QueueIntImpl(int capacity) {
        buffer = new int[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(int value) {
        if ((tail + 1) % buffer.length == head) {
            throw new IllegalStateException("Queue is full");
        }
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        size++;
        log();
    }

    @Override
    public int dequeue() {
        int value = buffer[head];
        head = (head + 1) % buffer.length;
        size--;
        log("dequeued value: " + value);
        return value;
    }
    
    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    
    private void log() {
        if (LOGGING) {
            System.out.println(this + (isEmpty() ? " empty" : " not emtpy"));
        }
    }
    
    private void log(String msg) {
        if (LOGGING) {
            log();
            System.out.println(msg);
        }
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

    public static void main(String[] args) {
        QueueInt q = new QueueIntImpl(4);
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        q.enqueue(44);
        q.dequeue();
        q.enqueue(55);
        q.dequeue();
        q.enqueue(66);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}
