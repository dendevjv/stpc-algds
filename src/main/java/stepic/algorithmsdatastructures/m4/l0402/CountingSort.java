package stepic.algorithmsdatastructures.m4.l0402;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.RandomArrays;

/**
 * Сортировка подсчетом.
 * Алгоритм 1.
 */
public class CountingSort {

    public static void main(String[] args) {
        final int MAXIMUM_VALUE_BOUND = 21;
        int[] a = RandomArrays.createInt(MAXIMUM_VALUE_BOUND - 1, MAXIMUM_VALUE_BOUND);
        
        System.out.println(Arrays.toString(a));
        sort(a, MAXIMUM_VALUE_BOUND);
        System.out.println(Arrays.toString(a));
    }

    /** Implements counting sort. */
    private static void sort(int[] data, int valueBound) {
        int[] counters = new int[valueBound];
        for (int i = 0; i < data.length; i++) {
            counters[data[i]]++;
        }
        int pos = 0;
        for (int i = 0; i < counters.length; i++) {
            for (int j = 0; j < counters[i]; j++) {
                data[pos++] = i;
            }
        }
    }

}
