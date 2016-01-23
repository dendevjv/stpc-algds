package stepic.algorithmsdatastructures.m4.l0402;

import java.util.Arrays;

import stepic.algorithmsdatastructures.tools.RandomArrays;

/**
 * Сортировка подсчетом.
 * Алгоритм 2. Не создает элементы A, а использует копирование.
 * Полезно при сортировке структур по некоторому полю.
 * 1) Заведем массив C[0, ..., k-1], посчитаем в C[i] количество 
 *    вхождений элемента i в массиве A.
 * 2) Вычислим границы групп элементов для каждого i 
 *    (начальные позиции каждой группы).
 * 3) Создаём массив B для результата.
 * 4) Переберем массив A. Очередной элемент A[i] разместим в B d
 *    позиции группы C[A[i]]. Увеличим текущую позицию группы.
 * 5) Скопируем B в A.
 */
public class CountingSortByCopying {

    public static void main(String[] args) {
        final int MAXIMUM_VALUE_BOUND = 11;
        int[] a = RandomArrays.createInt(MAXIMUM_VALUE_BOUND - 1, MAXIMUM_VALUE_BOUND);
        
        System.out.println(Arrays.toString(a));
        sort(a, MAXIMUM_VALUE_BOUND);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int valueBound) {
        int[] c = new int[valueBound];
        for (int i = 0; i < a.length; i++) {
            ++c[a[i]];
        }
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            int tmp = c[i];
            c[i] = sum; // start of the group
            sum += tmp;
        }
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
//            b[c[a[i]]++] = a[i];  // The short variant is not good for debugging
            int ai = a[i];          // ai and cai used for debugging
            int cai = c[ai]++;
            b[cai] = a[i];
        }
        System.arraycopy(b, 0, a, 0, b.length);
    }

}
