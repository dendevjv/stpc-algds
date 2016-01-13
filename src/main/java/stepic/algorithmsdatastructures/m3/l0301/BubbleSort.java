package stepic.algorithmsdatastructures.m3.l0301;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

public class BubbleSort {
    public static void main(String[] args) {
        int size = 20;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }

    private static void sort(int[] arr) {
        int tmp;
        boolean notSwapped;
        for (int outer = arr.length - 1; outer > 0; outer--) {
            notSwapped = true;
            for (int j = 0; j < outer; j++) {
                if (arr[j + 1] < arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    notSwapped = false;
                }
            }
            if (notSwapped) {
                break;
            }
        }
    }
    
}
