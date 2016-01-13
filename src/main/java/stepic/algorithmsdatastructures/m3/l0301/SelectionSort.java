package stepic.algorithmsdatastructures.m3.l0301;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

public class SelectionSort {

    public static void main(String[] args) {
        int size = 10;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }

    /** Implements selection sort */
    private static void sort(int[] arr) {
        int iMin, tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[iMin]) {
                    iMin = j;
                }
            }
            if (i != iMin) {
                tmp = arr[i];
                arr[i] = arr[iMin];
                arr[iMin] = tmp;
            }
        }
    }

}
