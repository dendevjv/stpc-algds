package stepic.algorithmsdatastructures.m4.l0401;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

public class QuickSort {

    public static void main(String[] args) {
        int size = 10;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }

    static void sort(int[] a, int from, int to) {
        int length = to - from;
        if (length < 2) {
            return;
        }
        int p = partition(a, from, to);
        if (p > from) {
            sort(a, from, p);
        }
        if (p + 1 < to) {
            sort(a, p + 1, to);
        }
    }

    private static  int partition(int[] a, int from, int to) {
        int pivot = a[to - 1];
        int i = from;
        int j = to - 2;
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (j >= 0 && a[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i++, j--);
            }
        }
        swap(a, i, to - 1);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
