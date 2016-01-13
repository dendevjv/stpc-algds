package stepic.algorithmsdatastructures.m3.l0301;

public class Ex07InsertionSort {
    public static void main(String[] args) {
        SortedArray array = new SortedArray();
        java.util.Scanner in = new java.util.Scanner(System.in);
        int x;
        while (in.hasNext()) {
            x = in.nextInt();
            array.add(x);
        }
        in.close();
        array.print();
    }

    private static class SortedArray {
        private static final int INITIAL_CAPACITY = 16;

        private int[] values = new int[INITIAL_CAPACITY];
        private int size;

        private void add(int x) {
            ensureCapacity(size + 1);

            int j = size;
            while (j > 0 && values[j - 1] > x) {
                values[j] = values[j - 1];
                j--;
            }
            values[j] = x;

            size++;
        }

        private void ensureCapacity(int capacity) {
            if (capacity > values.length) {
                values = java.util.Arrays.copyOf(values, values.length * 2);
            }
        }

        private void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }
    }

}
