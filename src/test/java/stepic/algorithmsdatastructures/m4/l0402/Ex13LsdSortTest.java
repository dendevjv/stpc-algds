package stepic.algorithmsdatastructures.m4.l0402;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import stepic.algorithmsdatastructures.tools.RandomArrays;

public class Ex13LsdSortTest {

    @Test
    public void testLsdSort() {
        long[] data = {4L, 1000_000L, 7L};
        long[] expected = {4L, 7L, 1000_000L};
        Ex13LsdSort.lsdSort(data);
        assertTrue(Arrays.equals(expected, data));
    }
    
    @Test
    public void testLsdSortRandom() {
        final int size = 100;
        for (int i = 0; i < 100; i++) {
            long[] initial = RandomArrays.createLong(size, size * 10);
            long[] data = Arrays.copyOf(initial, initial.length);
            long[] expected = Arrays.copyOf(data, data.length);
            Arrays.sort(expected);
            Ex13LsdSort.lsdSort(data);
            assertTrue("Failed on data:\n" + Arrays.toString(initial), Arrays.equals(expected, data));
        }
    }
}
