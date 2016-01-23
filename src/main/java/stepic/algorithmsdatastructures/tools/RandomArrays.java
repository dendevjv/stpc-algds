package stepic.algorithmsdatastructures.tools;

import java.util.Random;

public class RandomArrays {
    private static Random random = new Random();
    
    public static int[] createInt(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
    
    public static int[] createInt(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
    
    public static long[] createLong(int size, long bound) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = (long) (random.nextDouble() * bound);
        }
        return array;
    }
    
    public static long[] createLong(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }
}
