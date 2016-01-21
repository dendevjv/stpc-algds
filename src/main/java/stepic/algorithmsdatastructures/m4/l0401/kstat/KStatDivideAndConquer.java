/*
    Порядковые статистики. Алгоритм 1.
    Поиск К-ой порядковой статистики методом "Разделяй и властвуй". 
    Метод kStatDc(a, from, to, k)
    1. Выбираем пивот, вызываем partition.
    2. Пусть позиция пивота после разделения равна p.
       а) если p == k, то пивот является k-й порядковой статистикой.
       б) если p > k, то k-ая порядковая статистика находится слева,
          вызываем kStatDc(a, from, p, k).
       в) если p < k, то k-ая порядковая статистика находится справа,
          вызываем kStatDc(a, p + 1, to, k).
 */
package stepic.algorithmsdatastructures.m4.l0401.kstat;

import java.util.Scanner;

public class KStatDivideAndConquer {

    public static void main(String[] args) {
        int[] a = { 4, 7, 1, 3, 0, 6, 8, 5, 2 };
        Scanner in = new Scanner(System.in);
        System.out.print("Enter k: ");
        int k = in.nextInt();
        in.close();
        int r = kStatDc(a, 0, a.length, k);
        System.out.println(k + " stat is " + r);
    }

    static int kStatDc(int[] a, int from, int to, int k) {
        int pivotIdx = partition(a, from, to);
        if (pivotIdx == k) {
            return a[pivotIdx];
        } else if (k < pivotIdx) {
            return kStatDc(a, from, pivotIdx, k);
        } else {
            return kStatDc(a, pivotIdx + 1, to, k);
        }
    }
    
    private static int partition(int[] data, int from, int to) {
        int medianIdx = getMedianOfThreeValues(data, from, to);
        swap(data, medianIdx, to - 1);
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
                swap(data, i++, j--);
            }
        }
        swap(data, i, to - 1);
        return i;
    }
    
    private static void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    
    /**
     * Gets index of a median of starting, middle and last element of an array's segment.
     * @param data array containing the segment
     * @param from starting index of the segment
     * @param to ending index exclusive
     */
    private static int getMedianOfThreeValues(int[] data, int from, int to) {
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
