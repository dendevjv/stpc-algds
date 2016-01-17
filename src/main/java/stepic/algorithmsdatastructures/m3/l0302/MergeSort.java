package stepic.algorithmsdatastructures.m3.l0302;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

public class MergeSort {

    public static void main(String[] args) {
        int size = 20;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }

    private static void mergeSort(int[] arr, int from, int to) {
        int length = to - from;
        if (length < 2) {
            return;
        }
        int length1 = length / 2;
        int from2 = from + length1;
        
        mergeSort(arr, from, from2);
        mergeSort(arr, from2, to);
        merge(arr, from, from2, to);
    }

    private static void merge(int[] arr, int from1, int from2, int to2) {
        int len1 = from2 - from1;
        int len2 = to2 - from2;
        int[] buffer = new int[len1 + len2];
        int i = from1;
        int j = from2;
        int k = 0;
        while (i < from2 && j < to2) {
            if (arr[i] < arr[j]) {
                buffer[k++] = arr[i++];
            } else {
                buffer[k++] = arr[j++];
            }
        }
        if (i < from2) {
            while (i < from2) {
                buffer[k++] = arr[i++];
            }
        } else {
            while (j < to2) {
                buffer[k++] = arr[j++];
            }
        }
        System.arraycopy(buffer, 0, arr, from1, buffer.length);
    }

}
