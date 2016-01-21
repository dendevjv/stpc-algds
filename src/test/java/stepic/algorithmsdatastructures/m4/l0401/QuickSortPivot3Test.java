package stepic.algorithmsdatastructures.m4.l0401;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import stepic.algorithmsdatastructures.tools.RandomArrays;

public class QuickSortPivot3Test {

    @Test
    public void testSort() {
        final int arraySize = 1000;
        for (int i = 0; i < 100; i++) {
            int[] data = RandomArrays.createInt(arraySize);
            int[] expected = Arrays.copyOf(data, data.length);
            Arrays.sort(expected);
            QuickSortPivot3.sort(data);
            assertTrue(Arrays.equals(expected, data));
        }
    }

    @Test
    public void testMedian3() {
        int size = 3;
        assertEquals(1, new QuickSortPivot3(new int[] {1, 2, 3}).getMedianOfThreeValues(0, size));
        assertEquals(1, new QuickSortPivot3(new int[] {3, 2, 1}).getMedianOfThreeValues(0, size));
        assertEquals(0, new QuickSortPivot3(new int[] {2, 3, 1}).getMedianOfThreeValues(0, size));
        assertEquals(0, new QuickSortPivot3(new int[] {2, 1, 3}).getMedianOfThreeValues(0, size));
        assertEquals(2, new QuickSortPivot3(new int[] {1, 3, 2}).getMedianOfThreeValues(0, size));
        assertEquals(2, new QuickSortPivot3(new int[] {3, 1, 2}).getMedianOfThreeValues(0, size));
        
        assertEquals(1, new QuickSortPivot3(new int[] {2, 2, 3}).getMedianOfThreeValues(0, size));
        assertEquals(1, new QuickSortPivot3(new int[] {1, 2, 2}).getMedianOfThreeValues(0, size));
        
        size = 5;
        assertEquals(3, new QuickSortPivot3(new int[] {1, 24, 18, 10, 15, 6}).getMedianOfThreeValues(1, size + 1));
    }

}
