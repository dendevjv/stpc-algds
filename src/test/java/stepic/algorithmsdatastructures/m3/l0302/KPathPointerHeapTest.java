package stepic.algorithmsdatastructures.m3.l0302;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KPathPointerHeapTest {
    private static final int NUM_SUBARRAYS = 2;
    private static final int CAPACITY = 2;
    private static int[] data = {2, 1, 4, 3, 5};
    
    private KPathPointerHeap heap;

    @Before
    public void setUp() throws Exception {
        heap = new KPathPointerHeap(CAPACITY);
    }

    @Test
    public void testKPathPointerHeap() {
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testGetMin() {
        heap.add(createPointer(0, 0));
        heap.add(createPointer(1, 0));  // 2 1
        assertTrue(heap.isFull());
        
        KPathPointer m;
        m = heap.getMin();              // 2
        assertEquals(1, m.getValue());
        assertFalse(heap.isFull());
        
        heap.add(createPointer(0, 1));  // 2 4
        assertTrue(heap.isFull());
        m = heap.getMin();              // 4
        assertEquals(2, m.getValue());
        
        heap.add(createPointer(1, 1));  // 3 4
        m = heap.getMin();              // 4
        assertEquals(3, m.getValue());
        
        heap.add(createPointer(0, 2));  // 4 5
        m = heap.getMin();              // 5
        assertEquals(4, m.getValue());
        
        m = heap.getMin();              // empty
        assertEquals(5, m.getValue());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testAdd() {
        heap.add(createPointer(0, 0));
        heap.add(createPointer(1, 0));
        assertTrue(heap.isFull());
        
        KPathPointer m;
        m = heap.getMin();
        assertEquals(1, m.getValue());
        m = heap.getMin();
        assertEquals(2, m.getValue());
        assertTrue(heap.isEmpty());
    }

    private SubArrayValuePointer createPointer(int arrayIdx, int valueIdx) {
        return new SubArrayValuePointer(data, NUM_SUBARRAYS, arrayIdx, valueIdx);
    }
}
