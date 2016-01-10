package stepic.algorithmsdatastructures.m2.l0202;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    private PriorityQueue pq;

    @Before
    public void setUp() throws Exception {
        pq = new PriorityQueue();
    }

    @Test
    public void testPriorityQueue() {
        assertTrue(pq.isEmpty());
        
        int[] values = {33, 22, 66, 11, 77, 44, 55};
        pq = new PriorityQueue(values);
        assertFalse(pq.isEmpty());
        
        assertEquals(77, pq.getNext());
        assertEquals(66, pq.getNext());
        assertEquals(55, pq.getNext());
        assertEquals(44, pq.getNext());
        assertEquals(33, pq.getNext());
        assertEquals(22, pq.getNext());
        assertEquals(11, pq.getNext());
        assertTrue(pq.isEmpty());
    }

    @Test
    public void testAdd() {
        pq.add(11);
        assertEquals(11, pq.getNext());
        assertTrue(pq.isEmpty());
        
        pq.add(33);
        pq.add(22);
        assertEquals(33, pq.getNext());
        assertEquals(22, pq.getNext());
        assertTrue(pq.isEmpty());
        
        pq.add(44);
        pq.add(55);
        pq.add(66);
        assertEquals(66, pq.getNext());
        assertEquals(55, pq.getNext());
        assertEquals(44, pq.getNext());
        assertTrue(pq.isEmpty());
    }

    @Test
    public void testGetNext() {
        pq.add(11);
        pq.add(22);
        pq.add(33);
        pq.add(44);
        
        assertEquals(44, pq.getNext());
        assertEquals(33, pq.getNext());
    }

    @Test
    public void testAddRandomValues() {
        Random rnd = new Random();
        final int length = 100;
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = rnd.nextInt();
        }
        for (int i = 0; i < length; i++) {
            pq.add(values[i]);
        }
        
        Arrays.sort(values);
        for (int i = length - 1; i >= 0; i--) {
            assertEquals(values[i], pq.getNext());
        }
    }
}
