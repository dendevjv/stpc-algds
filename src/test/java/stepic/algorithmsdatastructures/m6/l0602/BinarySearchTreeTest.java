package stepic.algorithmsdatastructures.m6.l0602;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<>();
    }

    @Test
    public void testContains() {
        int x;
        
        x = 2;
        assertFalse(tree.contains(x));
        tree.add(x);
        assertTrue(tree.contains(x));
        
        x = 3;
        assertFalse(tree.contains(x));
        tree.add(x);
        assertTrue(tree.contains(x));
        
        x = 1;
        assertFalse(tree.contains(x));
        tree.add(x);
        assertTrue(tree.contains(x));
    }

    @Test
    public void testDeleteSingle() {
        int x = 1;
        assertFalse(tree.delete(x));
        
        tree.add(x);
        assertTrue(tree.contains(x));
        assertTrue(tree.delete(x));
        assertFalse(tree.contains(x));
    }
    
    @Test
    public void testDeleteWhenNoChildern() {
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        
        boolean r;
        r = tree.delete(1);
        assertTrue(r);
        assertFalse(tree.contains(1));
        
        r = tree.delete(7);
        assertTrue(r);
        assertFalse(tree.contains(7));
        
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(5));
    }
    
    @Test
    public void testDeleteWhenOneChildLeafRight() {
        tree.add(44);
        tree.add(22);
        tree.add(33);
        
        boolean r;
        r = tree.delete(22);
        assertTrue(r);
        assertFalse(tree.contains(22));
        
        assertTrue(tree.contains(44));
        assertTrue(tree.contains(33));
    }
    
    @Test
    public void testDeleteWhenOneChildLeafLeft() {
        tree.add(44);
        tree.add(22);
        tree.add(11);
        
        assertTrue(tree.delete(22));
        assertFalse(tree.contains(22));
        
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(44));
    }
    
    @Test
    public void testDeleteWhenOneChildLeft() {
        tree.add(44);
        tree.add(22);
        tree.add(11);
        tree.add(5);
        tree.add(15);
        
        assertTrue(tree.delete(22));
        assertFalse(tree.contains(22));
        
        assertTrue(tree.contains(44));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(15));
    }
    
    @Test
    public void testDeleteWhenOneChildRight() {
        tree.add(44);
        tree.add(22);
        tree.add(33);
        tree.add(30);
        tree.add(36);
        
        assertTrue(tree.delete(22));
        assertFalse(tree.contains(22));
        
        assertTrue(tree.contains(44));
        assertTrue(tree.contains(33));
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(36));
    }
    
    @Test
    public void testDeleteWhenTwoChildren() {
        tree.add(44);
        tree.add(22);
        tree.add(11);
        tree.add(5);
        tree.add(15);
        tree.add(33);
        tree.add(30);
        tree.add(36);
        
        assertTrue(tree.delete(22));
        assertFalse(tree.contains(22));
        
        assertTrue(tree.contains(44));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(33));
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(36));
    }
    
    @Test
    public void testDeleteWhenRoot() {
        tree.add(33);
        tree.add(44);
        tree.add(22);
        
        assertTrue(tree.delete(44));
        assertFalse(tree.contains(44));
        
        assertTrue(tree.contains(22));
        assertTrue(tree.contains(33));
        // TODO Validate tree
    }
    
    @Test
    public void testDelete() {
        tree.add(22);
        tree.add(33);
        tree.add(44);
        
        assertTrue(tree.delete(22));
        assertFalse(tree.contains(22));
        
        assertTrue(tree.contains(33));
        assertTrue(tree.contains(44));
    }
    
    @Test
    public void testDeleteWhenTwoChildrenAnd3Levels() {
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(5);
        
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(5));
        
        assertTrue(tree.delete(3));
        assertFalse(tree.contains(3));
        // Others left
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(5));
    }
    
    @Test
    public void testGetMin() {
        tree.add(3);
        tree.add(1);
        tree.add(7);
        tree.add(5);
        
        assertEquals(Integer.valueOf(1), tree.getMin());
    }
    
    @Test
    public void testGetMax() {
        tree.add(3);
        tree.add(1);
        tree.add(7);
        tree.add(5);
        
        assertEquals(Integer.valueOf(7), tree.getMax());
    }

    @Test
    public void testAdd() {
        tree.add(2);
        assertTrue(tree.contains(2));
        
        tree.add(1);
        assertTrue(tree.contains(1));
        
        tree.add(3);
        assertTrue(tree.contains(3));
    }

    @Test
    public void testIterator() {
        fail("Not implemented");
        tree.add(44);
        tree.add(22);
        tree.add(11);
        tree.add(5);
        tree.add(15);
        tree.add(33);
        tree.add(30);
        tree.add(36);
        tree.add(77);
        tree.add(66);
        tree.add(55);
        
        int[] d = {5, 11, 15, 22, 30, 33, 36, 44, 55, 77};
        Iterator<Integer> it = tree.iterator();
        int i = 0;
        while (it.hasNext()) {
            Integer actual = it.next();
//            Integer expected = Integer.valueOf(d[i++]);
            System.out.print(actual + " ");
//            assertEquals(expected, actual);
        }
        System.out.println("\nFinished");
    }

}
