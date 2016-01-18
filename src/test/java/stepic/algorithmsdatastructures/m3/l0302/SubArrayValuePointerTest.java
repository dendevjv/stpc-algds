package stepic.algorithmsdatastructures.m3.l0302;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubArrayValuePointerTest {
    private static int[] data = new int[] {2, 1, 3};
    private static SubArrayValuePointer p00 = new SubArrayValuePointer(data, 2, 0, 0); // 2
    private static SubArrayValuePointer p01 = new SubArrayValuePointer(data, 2, 0, 1); // 3
    private static SubArrayValuePointer p10 = new SubArrayValuePointer(data, 2, 1, 0); // 1
    private static SubArrayValuePointer p11 = new SubArrayValuePointer(data, 2, 1, 1); // not valid

    @Test
    public void testCompareTo() {
        assertTrue(p00.compareTo(p01) < 0);
        assertTrue(p00.compareTo(p10) > 0);
        
        assertTrue(p01.compareTo(p00) > 0);
        assertTrue(p01.compareTo(p10) > 0);
        
        assertTrue(p10.compareTo(p00) < 0);
        assertTrue(p10.compareTo(p01) < 0);
        assertTrue(p10.compareTo(p10) == 0);
    }

    @Test
    public void testGetValue() {
        assertEquals(1, p10.getValue());
        assertEquals(2, p00.getValue());
        assertEquals(3, p01.getValue());
    }

    @Test
    public void testIsValid() {
        assertTrue(p10.isValid());
        assertFalse(p11.isValid());
    }
    
    @Test
    public void testGetRealIndex() {
        assertEquals(0, p00.getRealIndex());
        assertEquals(1, p10.getRealIndex());
        assertEquals(2, p01.getRealIndex());
    }
}
