package stepic.algorithmsdatastructures.m1.l0103;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchRecursive {
    private static int findInsertionPoint(int[] arr, int first, int last, int element) {
        if (first == last) {
            return first;
        }
        int mid = first + (last - first) / 2;
        if (element <= arr[mid]) {
            return findInsertionPoint(arr, first, mid, element);
        } else {
            return findInsertionPoint(arr, mid + 1, last, element);
        }
    }
    
    static int search(int[] arr, int element) {
        int point = findInsertionPoint(arr, 0, arr.length, element);
        return (point == arr.length || arr[point] != element) ? -1 : point;
    }
    
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[10];
        int bound = arr.length / 3 * 2;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        Scanner in = new Scanner(System.in);
        System.out.print("Element: ");
        int element = in.nextInt();
        in.close();
        int r = search(arr, element);
        System.out.println("r = " + r);
    }
}
