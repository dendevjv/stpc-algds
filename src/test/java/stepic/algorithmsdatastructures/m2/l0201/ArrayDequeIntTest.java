package stepic.algorithmsdatastructures.m2.l0201;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayDequeIntTest {
    private ArrayDequeInt deque;

    @Before
    public void setUp() throws Exception {
        deque = new ArrayDequeInt(2);
    }

    @Test
    public void testArrayDequeInt() {
        assertEquals("[]", deque.toString());
    }
    
    @Test
    public void testPushFront() {
        deque.pushFront(11);
        assertEquals("[11]", deque.toString());
        deque.pushFront(22);
        assertEquals("[22, 11]", deque.toString());
        deque.pushFront(33);
        assertEquals("[33, 22, 11]", deque.toString());
    }
    
    @Test
    public void testPushFrontPopFront() {
        deque.pushFront(11);
        deque.pushFront(22);
        deque.pushFront(33);
        int r;
        r = deque.popFront();
        assertEquals(33, r);
        r = deque.popFront();
        assertEquals(22, r);
        r = deque.popFront();
        assertEquals(11, r);
    }
    
    @Test
    public void testPushFrontPopBack() {
        deque.pushFront(11);
        deque.pushFront(22);
        deque.pushFront(33);
        int r;
        r = deque.popBack();
        assertEquals(11, r);
        r = deque.popBack();
        assertEquals(22, r);
        r = deque.popBack();
        assertEquals(33, r);
    }
    
    @Test
    public void testPopFront() {
        int r;
        deque.pushFront(11);
        r = deque.popFront();
        assertEquals(11, r);
        r = deque.popFront();
        assertEquals(-1, r);
        
        deque.pushFront(33);
        deque.pushBack(44);
        deque.pushFront(22);
        r = deque.popFront();
        assertEquals(22, r);
        r = deque.popFront();
        assertEquals(33, r);
        r = deque.popFront();
        assertEquals(44, r);
        
        r = deque.popFront();
        assertEquals(-1, r);
    }

    @Test
    public void testPushBack() {
        deque.pushBack(11);
        assertEquals("[11]", deque.toString());
        deque.pushBack(22);
        assertEquals("[11, 22]", deque.toString());
        deque.pushBack(33);
        assertEquals("[11, 22, 33]", deque.toString());
    }
    
    @Test
    public void testPushBackPopBack() {
        deque.pushBack(11);
        deque.pushBack(22);
        deque.pushBack(33);
        int r;
        r = deque.popBack();
        assertEquals(33, r);
        r = deque.popBack();
        assertEquals(22, r);
        r = deque.popBack();
        assertEquals(11, r);
    }

    @Test
    public void testPopBack() {
        int r;
        deque.pushBack(11);
        r = deque.popBack();
        assertEquals(11, r);
        r = deque.popFront();
        assertEquals(-1, r);
        
        deque.pushBack(33);
        deque.pushFront(44);
        deque.pushBack(22);
        r = deque.popBack();
        assertEquals(22, r);
        r = deque.popBack();
        assertEquals(33, r);
        r = deque.popBack();
        assertEquals(44, r);
        
        r = deque.popBack();
        assertEquals(-1, r);
    }

}
