package stepic.algorithmsdatastructures.m4.l0401;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

/**
 * Quick sort c оптимизацией выбора опорного элемента (из 0-го, среднего и последнего).
 */
public class QuickSortPivot3 {

    static final int INSERTION_SORT_LIMIT = 50;
    
    private int[] data;
    
    QuickSortPivot3(int[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
        int size = 30;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }
    
    static void sort(int[] data) {
        new QuickSortPivot3(data).sort();
    }
    
    private void sort() {
        sort(0, data.length);
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
