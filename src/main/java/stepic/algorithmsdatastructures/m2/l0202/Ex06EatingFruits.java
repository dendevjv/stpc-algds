/*
    Жадина.
    -------
    Вовочка ест фрукты из бабушкиной корзины. В корзине лежат фрукты разной массы. 
    Вовочка может поднять не более K грамм. Каждый фрукт весит не более K грамм. 
    За раз он выбирает несколько самых тяжелых фруктов, которые может поднять одновременно, 
    откусывает от каждого половину и кладет огрызки обратно в корзину. 
    Если фрукт весит нечетное число грамм, он откусывает большую половину. 
    Фрукт массы 1гр он съедает полностью.
    Определить за сколько подходов Вовочка съест все фрукты в корзине.
    Напишите свой класс кучи, реализующий очередь с приоритетом.
    
    Формат входных данных. Вначале вводится n - количество фруктов и строка с 
    целочисленными массами фруктов через пробел. 
    Затем в отдельной строке K - "грузоподъемность".
    
    Формат выходных данных. Неотрицательное число - количество подходов к корзине.
    
    Sample Input:
        3
        1 2 2
        2
    
    Sample Output:
        4
 */
package stepic.algorithmsdatastructures.m2.l0202;

public class Ex06EatingFruits {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = in.nextInt();
        }
        int k = in.nextInt();
        in.close();
        
        int count = countResult(fruits, k);
        System.out.println(count);
    }
    
    private static class PQueue {
        private static final int INITIAL_CAPACITY = 16;
        private int size;
        private int[] data;
        
        public PQueue() {
            data = new int[INITIAL_CAPACITY];
        }
        
        public PQueue(int[] values) {
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

    static int countResult(int[] fruits, int limit) {
        int count = 0;
        PQueue pq = new PQueue(fruits);
        while (!pq.isEmpty()) {
            int handful = 0;
            PQueue buffer = new PQueue();
            while (!pq.isEmpty()) {
                int fruit = pq.peekNext();
                if ((handful + fruit) <= limit) {
                    handful += fruit;
                    pq.getNext();
                    if (fruit > 1) {
                        buffer.add(fruit / 2);
                    }
                } else {
                    break;
                }
            }
            while (!buffer.isEmpty()) {
                pq.add(buffer.getNext());
            }
            count++;
        }
        return count;
    }

}
