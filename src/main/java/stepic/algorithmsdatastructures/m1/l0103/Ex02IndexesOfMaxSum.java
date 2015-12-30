/*
    Даны два массива целых чисел одинаковой длины A[0..n-1] и B[0..n-1].
    Неободимо найти первую пару индексов i0 и j0, i0 <= j0, такую что
    A[i0] + B[j0] = max{A[i] + B[j], где 0 <= i < n, 0 <= j < n, i <= j}.
    Время работы - O(n).
    Ограничения: 1 <= n <= 100000, 0 <= A[i] <= 100000, 0 <= B[i] <= 100000 для любого i.
    Sample Input:
    4
    4 -8 6 0        -- ОЧЕВИДНО ОШИБКА В ЗАДАНИИ (ввод отрицательных чисел)
    -10 3 1 1
    Sample Output:
    0 1
 */
package stepic.algorithmsdatastructures.m1.l0103;

public class Ex02IndexesOfMaxSum {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        in.close();
        findIndexesOfMaxSum(a, b);
    }
    
    private static void findIndexesOfMaxSum(int[] a, int[] b) {
        int iMax = 0;
        int iMax0 = iMax;
        int jMax = 0;
        int maxA = a[0];
        int maxAB = maxA + b[0];
        int sumAB;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxA) {
                maxA = a[i];
                iMax0 = i;
            }
            sumAB = maxA + b[i];
            if (sumAB > maxAB) {
                maxAB = sumAB;
                jMax = i;
                iMax = iMax0;
            }
        }
        System.out.println(iMax + " " + jMax);
    }

}
