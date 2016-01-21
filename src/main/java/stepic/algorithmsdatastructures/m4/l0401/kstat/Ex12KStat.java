/*
    Даны неотрицательные целые числа n, k и массив целых чисел из [0..10^9] размера n. 
    Требуется найти k-ю порядковую статистику, т.е. напечатать число, 
    которое бы стояло на позиции с индексом k (0..n-1) в отсортированном массиве. 
    Напишите нерекурсивный алгоритм методом "разделяй и властвуй".
    Требования к дополнительной памяти: O(n). Требуемое среднее время работы: O(n).
    Функцию Partition следует реализовывать методом прохода двумя итераторами в одном направлении от начала массива к концу:
         1. Выбирается опорный элемент. Опорный элемент меняется с последним элементом массива.
         2. Во время работы Partition в начале массива содержатся элементы, не бОльшие опорного. 
            Затем располагаются элементы, строго бОльшие опорного. 
            В конце массива лежат нерассмотренные элементы. Последним элементом лежит опорный.
         3. Итератор (индекс) i указывает на начало группы элементов, строго бОльших опорного.
         4. Итератор j больше i, итератор j указывает на первый нерассмотренный элемент.
         5. Шаг алгоритма. Рассматривается элемент, на который указывает j. 
            Если он больше опорного, то сдвигаем j. Если он не больше опорного, 
            то меняем a[i] и a[j] местами, сдвигаем i и сдвигаем j.
         6. В конце работы алгоритма меняем опорный и элемент, на который указывает итератор i.
 */
package stepic.algorithmsdatastructures.m4.l0401.kstat;

public class Ex12KStat {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        
        int kStat = kStatDc(a, k);
        System.out.println(kStat);
    }
    
    static int kStatDc(int[] a, int k) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int p = partition(a, lo, hi);
            if (p == k) {
                return a[p];
            } else if (k < p){
                hi = p;
            } else {
                lo = p + 1;
            }
        }
        return -1;
    }

    static int partition(int[] a, int from, int to) {
        int pivotIdx = getMedianOfThreeValues(a, from, to);
        int last = to - 1;
        swap(a, pivotIdx, last);
        int pivot = a[last];
        
        int i = 0;
        int j = 0;
        while (j < last) {
            if (a[j] > pivot) {
                j++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
        swap(a, i, last);
        return i;
    }
    
    private static void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * Gets index of a median of starting, middle and last element of an array's segment.
     * @param data array containing the segment
     * @param from starting index of the segment
     * @param to ending index exclusive
     */
    private static int getMedianOfThreeValues(int[] data, int from, int to) {
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
