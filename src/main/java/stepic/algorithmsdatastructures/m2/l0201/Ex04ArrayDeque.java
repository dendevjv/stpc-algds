/*
    Реализуйте дек с динамическим зацикленным буфером.
    Для тестирования дека на вход подаются команды.
    В первой строке количество команд. Затем в каждой строке записана одна команда. 
    Каждая команда задаётся как 2 целых числа: a b.
    a = 1 - push front,
    a = 2 - pop front,
    a = 3 - push back, 
    a = 4 - pop back.
    Если дана команда pop*, то число b - ожидаемое значение. Если команда pop вызвана для пустой структуры данных, то ожидается “-1”.
    Требуется напечатать YES, если все ожидаемые значения совпали. Иначе, если хотя бы одно ожидание не оправдалось, то напечатать NO.
    Sample Input:
    5
    1 44
    3 50
    2 44
    2 50
    2 -1
    Sample Output:
    YES
 */
package stepic.algorithmsdatastructures.m2.l0201;

public class Ex04ArrayDeque {
    private static class ArrayDeque {
        private static final int NON_EXISTING_VALUE = -1;

        private static final int DEFAULT_CAPACITY = 16;
        
        private int[] buffer;
        /** Index of first element */
        private int head;
        /** Index of the element after the last element */
        private int tail;
        private int size;
        
        public ArrayDeque() {
            this(DEFAULT_CAPACITY);
        }
        
        public ArrayDeque(int initialCapacity) {
            buffer = new int[initialCapacity];
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
    }

    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque();
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt(), a, b, r;
        boolean yes = true;
        for (int i = 0; i < n; i++) {
            a = in.nextInt();
            b = in.nextInt();
            switch (a) {
            case 1:
                deque.pushFront(b);
                break;
            case 2:
                r = deque.popFront();
                if (r != b) {
                    yes = false;
                }
                break;
            case 3:
                deque.pushBack(b);
                break;
            case 4:
                r = deque.popBack();
                if (r != b) {
                    yes = false;
                }
                break;
            }
        }
        in.close();
        System.out.println(yes ? "YES" : "NO");
    }

}
