/*
    Дан массив неотрицательных целых 64-разрядных чисел. Количество чисел не больше 10^6. 
    Отсортируйте массив методом поразрядной сортировки LSD по байтам.
    Слова "LSD по байтам" означают, что каждый проход поразрядной сортировки должен 
    стабильно сортировать все числа массива по очередному байту. 
    Начиная от младших к старшим. 64-разрядное число записывается 8 байтами, 
    поэтому всего таких проходов будет 8.
    Sample Input:
        3
        4 1000000 7
    Sample Output:
        4 7 1000000
 */
package stepic.algorithmsdatastructures.m4.l0402;

public class Ex13LsdSort {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextLong();
        }
        in.close();
        
        lsdSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    
    private static final int BITS_PER_BYTE = 8;
    private static final int BYTE_SIZE = 256;
    private static final int NUM_BYTES = Long.BYTES;
    private static final int LEAST_SIGNIFICANT_BYTE_INDEX = NUM_BYTES - 1;

    static void lsdSort(long[] a) {
        for (int b = LEAST_SIGNIFICANT_BYTE_INDEX; b >= 0; b--) {
            countingSort(a, b);
        }
    }

    private static void countingSort(long[] a, int byteIndex) {
        int[] c = new int[BYTE_SIZE];
        int bitShifts = (NUM_BYTES - byteIndex - 1) * BITS_PER_BYTE;
        int byteValue;
        for (int i = 0; i < a.length; i++) {
            byteValue = ((int) (a[i] >> bitShifts)) & 0xFF;
            ++c[byteValue];
        }
        int sum = 0, tmp;
        for (int i = 0; i < c.length; i++) {
            tmp = c[i];
            c[i] = sum;
            sum += tmp;
        }
        long[] b = new long[a.length];
        for (int i = 0; i < b.length; i++) {
            byteValue = ((int) (a[i] >> bitShifts)) & 0xFF;
            int j = c[byteValue]++;
            b[j] = a[i];
        }
        System.arraycopy(b, 0, a, 0, b.length);
    }

}
