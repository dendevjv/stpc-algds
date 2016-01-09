/*
    Дан отсортированный массив различных целых чисел A[0..n-1] и массив целых чисел B[0..m-1].
    Для каждого элемента массива B[i] найдите минимальный индекс элемента массива A[k],
    ближайшего по значению к B[i].
    Время работы поиска для каждого элемента B[i]: O(log(k)).
    Подсказка. Обратите внимание, что время работы должно зависеть от индекса ответа - k. 
    Для достижения такой асимптотики предлагается для начала найти отрезок вида [2^p,2^(p+1)] , 
    содержащий искомую точку, а уже затем на нём выполнять традиционный бин. поиск.
    
    Sample Input:
        3
        10 20 30
        3
        9 15 35
    Sample Output:
        0 0 2
 */
package stepic.algorithmsdatastructures.m1.l0103;

public class Ex03IndexOfMinNearest {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int[] arr1 = getArray(in);
        int[] arr2 = getArray(in);
        in.close();

        for (int n : arr2) {
            int r = findMinimalNearest(arr1, n);
            System.out.print(r + " ");
        }
        System.out.println();
    }

    static int findMinimalNearest(int[] array, int number) {
        if (number < array[0]) {
            return 0;
        }
        if (number > array[array.length - 1]) {
            return array.length - 1;
        }
        int lo = 0;
        int hi = array.length;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (number <= array[m]) {
                hi = m;
            } else {
                lo = m + 1;
            }
        }

        if (array[lo] == number) {
            while (lo >= 0 && array[lo] == number) {
                lo--;
            }
            return lo + 1;
        } else if ((number - array[lo - 1]) > (array[lo] - number)) {
            return lo;
        } else {
            lo--;
            int t = array[lo];
            while (lo >= 0 && array[lo] == t) {
                lo--;
            }
            return lo + 1;
        }
    }

    private static int[] getArray(java.util.Scanner in) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }
}
