package stepic.algorithmsdatastructures.m3.l0401;

import java.util.Arrays;
import java.util.Scanner;

import stepic.algorithmsdatastructures.m3.l0301.InsertionSort;
import stepic.algorithmsdatastructures.tools.RandomArrays;
import stepic.algorithmsdatastructures.tools.StopWatch;

public class CompareQuickAndInsertion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of arrays and array size: ");
        int numArrays = in.nextInt();
        int arraySize = in.nextInt();
        in.close();
        
        int[][] testData = new int[numArrays][];
        for (int i = 0; i < testData.length; i++) {
            testData[i] = RandomArrays.createInt(arraySize);
        }
        
        int[][] data1 = copy(testData);
        int[][] data2 = copy(testData);
        int[][] data3 = copy(testData);
        
        // Quick sort
        StopWatch sw1 = new StopWatch();
        sw1.start();
        for (int i = 0; i < data1.length; i++) {
            QuickSort.sort(data1[i], 0, data1[i].length);
        }
        sw1.stop();
        System.out.println("Quick sorting: " + sw1.getElapsedTime());
        
        // Insertion sort
        StopWatch sw2 = new StopWatch();
        sw2.start();
        for (int i = 0; i < data2.length; i++) {
            InsertionSort.sort(data2[i]);
        }
        sw2.stop();
        System.out.println("Insertion sorting: " + sw2.getElapsedTime());
        
        // Optimized Quick sort
        StopWatch sw3 = new StopWatch();
        sw3.start();
        for (int i = 0; i < data3.length; i++) {
            QuickSortPivot3.sort(data3[i]);
        }
        sw3.stop();
        System.out.println("Optimized sorting: " + sw3.getElapsedTime());
    }
    
    /*
             Results:
             
        Enter number of arrays and array size: 1000 10000
        Quick sorting: 757
        Insertion sorting: 26172
        Optimized sorting: 664
        
        Enter number of arrays and array size: 10000 1000
        Quick sorting: 596
        Insertion sorting: 2699
        Optimized sorting: 513
        
        Enter number of arrays and array size: 100000 100
        Quick sorting: 432
        Insertion sorting: 371
        Optimized sorting: 332
        
        Enter number of arrays and array size: 200000 50
        Quick sorting: 381
        Insertion sorting: 242
        Optimized sorting: 283
        
        
        Enter number of arrays and array size: 400000 20
        Quick sorting: 253
        Insertion sorting: 126
        Optimized sorting: 139
        
        Enter number of arrays and array size: 500000 10
        Quick sorting: 126
        Insertion sorting: 61
        Optimized sorting: 73
     */
    
    private static int[][] copy(int[][] data) {
        int[][] result = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            result[i] = Arrays.copyOf(data[i], data[i].length);
        }
        return result;
    }

}
