package stepic.algorithmsdatastructures.m3.l0302;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.ArrayTester;
import stepic.algorithmsdatastructures.tools.RandomArrays;

public class HeapSort {

    public static void main(String[] args) {
        int size = 20;
        int[] arr = RandomArrays.createInt(size, size * 2);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Non-decreasing: " + ArrayTester.isNonDecreasing(arr));
    }

    /** Implements heap sort */
    private static void sort(int[] arr) {
        Heap heap = new Heap(arr);
        while (heap.getSize() > 1) {
            int m = heap.getMax();
            arr[heap.getSize()] = m;
        }
    }
    
    private static class Heap {
        private int[] array;
        private int size;
        
        private Heap(int[] array) {
            this.array = array;
            size = 1;
            build();
        }
        
        private int getMax() {
            int m = array[0];
            array[0] = array[size - 1];
            size--;
            siftDown(0);
            return m;
        }
        
        private int getSize() {
            return size;
        }

        private void build() {
            size = array.length;
            for (int parent = (size - 2) / 2; parent >= 0; --parent) {
                siftDown(parent);
            }
        }

        private void siftDown(int i) {
            int left = i * 2 + 1;
            if (left < size) {
                int greater = left;
                int right = i * 2 + 2;
                if (right < size && array[right] > array[left]) {
                    greater = right;
                }
                if (array[greater] > array[i]) {
                    swap(i, greater);
                    siftDown(greater);
                }
            }
        }
        
        private void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

}
