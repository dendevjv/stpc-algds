/*
    Дан массив целых чисел в диапазоне [0..10^9]. 
    Размер массива кратен 10 и ограничен сверху значением 2.5 * 10^7 элементов. 
    Все значения массива являются элементами псевдо-рандомной последовательности. 
    Необходимо отсортировать элементы массива за минимально время с использованием 
    быстрой сортировки и вывести каждый десятый элемент отсортированной 
    последовательности.
    Минимальный набор оптимизаций, который необходимо реализовать:
    1. Оптимизация выбора опорного элемента.
    2. Оптимизация концевой рекурсии.
    Sample Input:
        3 0 2 1 5 4 21 4 6 5
    Sample Output:
        21
 */
package stepic.algorithmsdatastructures.m4.l0401;

public class Ex11QuickSort {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        final int n = 25000000;
        int[] data = new int[n];
        int size = 0;
        while (in.hasNextInt()) {
            data[size++] = in.nextInt();
        }
        in.close();
        QuickSort3.sort(data, size);
        for (int i = 9; i < size; i += 10) {
            System.out.print(data[i] + " ");
        }
    }

    private static class QuickSort3 {

        static final int INSERTION_SORT_LIMIT = 50;
        
        private int[] data;
        private int size;
        
        QuickSort3(int[] data, int size) {
            this.data = data;
            this.size = size;
        }
        
        static void sort(int[] data, int size) {
            new QuickSort3(data, size).sort();
        }
        
        private void sort() {
            sort(0, size);
        }
        
        private void sort(int from, int to) {
            int lenght = to - from;
            if (lenght < 2) {
                return;
            } else if (lenght < INSERTION_SORT_LIMIT) { 
                for (int i = from + 1; i < to; i++) {
                    int j = i;
                    int v = data[j];
                    while (j > from && data[j - 1] > v) {
                        data[j] = data[j - 1];
                        j--;
                    }
                    data[j] = v;
                }
            } else {
                int mi = getMedianOfThreeValues(from, to);
                swap(mi, to - 1);
                
                int p = partition(from, to);
                if (p > from) {
                    sort(from, p);
                }
                if (p + 1 < to) {
                    sort(p + 1, to);
                }
            }
        }
        
        private void swap(int i, int j) {
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        private int partition(int from, int to) {
            int i = from;
            int j = to - 2;
            int pivot = data[to - 1];
            while (i <= j) {
                while (data[i] < pivot) {
                    i++;
                }
                while (j >= from && data[j] >= pivot) {
                    j--;
                }
                if (i < j) {
                    swap(i++, j--);
                }
            }
            swap(i, to - 1);
            return i;
        }

        /**
         * Gets index of a median of starting, middle and last element of an array.
         * @param from starting index
         * @param to ending index exclusive
         */
        int getMedianOfThreeValues(int from, int to) {
            int i0 = from;
            int length = to - from;
            int i1 = from + length / 2;
            int i2 = from + length - 1;
            int t;
            if (data[i0] > data[i1]) {
                t = i0;
                i0 = i1;
                i1 = t;
            }
            if (data[i1] > data[i2]) {
                t = i2;
                i2 = i1;
                i1 = t;
            }
            if (data[i0] > data[i1]) {
                t = i1;
                i1 = i0;
                i0 = t;
            }
            return i1;
        }
    }
}
