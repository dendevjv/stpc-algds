package stepic.algorithmsdatastructures.m3.l0301;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

public class InsertionSort {

    public static void main(String[] args) {
        int size = 10;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }

    /** Implements insertion sort. */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

}
