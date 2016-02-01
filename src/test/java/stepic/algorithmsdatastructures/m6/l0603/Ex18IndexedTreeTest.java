package stepic.algorithmsdatastructures.m6.l0603;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import stepic.algorithmsdatastructures.tools.SystemOutTester;

public class Ex18IndexedTreeTest {

//    @Test
    public void testMain() {
        try (SystemOutTester out = new SystemOutTester()) {
            String input = "2 4 6 -2";
//            String input = "1 2 3 4 5 6 7 -4 -5 -6 -3 -1";
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf ));
            
            Ex18IndexedTree.main(null);
            
            String actual = out.getOutput();
            assertEquals("2" + System.lineSeparator(), actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }
    
    @Test
    public void testEx18IndexedTreeAvlTree() {
        Ex18IndexedTree.AvlTree tree = new Ex18IndexedTree.AvlTree();
        
        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        String actual;
        actual = tree.toStringInOrder();
        assertEquals("[7 6 5 4 3 2 1 ]", actual);
        
        tree.delete(4);
        actual = tree.toStringInOrder();
        assertEquals("[7 6 5 3 2 1 ]", actual);
        
        tree.delete(5);
        actual = tree.toStringInOrder();
        assertEquals("[7 6 3 2 1 ]", actual);
        
        tree.delete(7);
        actual = tree.toStringInOrder();
        assertEquals("[6 3 2 1 ]", actual);
        
        tree.delete(6);
        actual = tree.toStringInOrder();
        assertEquals("[3 2 1 ]", actual);
    }
    
    @Test
    public void testEx18IndexedTreeAvlTreeIndexes() {
        Ex18IndexedTree.AvlTree tree = new Ex18IndexedTree.AvlTree();
        int i;
        
        i = tree.add(6);
        assertEquals(0, i);
        i = tree.add(4);
        assertEquals(1, i);
        i = tree.add(2);
        assertEquals(2, i);
        i = tree.add(7);
        assertEquals(0, i);
        i = tree.add(5);
        assertEquals(2, i);
        i = tree.add(3);
        assertEquals(4, i);
        i = tree.add(1);
        assertEquals(6, i);
    }
    
    @Test
    public void testEx18IndexedTreeAvlTreeDeleteByIndex() {
        Ex18IndexedTree.AvlTree tree = new Ex18IndexedTree.AvlTree();

        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        
        String actual;
        actual = tree.toStringInOrder();
        assertEquals("[7 6 5 4 3 2 1 ]", actual);
        
        tree.deleteByIndex(6);
        actual = tree.toStringInOrder();
        assertEquals("[7 6 5 4 3 2 ]", actual);
        
        tree.deleteByIndex(0);
        actual = tree.toStringInOrder();
        assertEquals("[6 5 4 3 2 ]", actual);
        
        tree.deleteByIndex(2);
        actual = tree.toStringInOrder();
        assertEquals("[6 5 3 2 ]", actual);
        
        tree.deleteByIndex(2);
        actual = tree.toStringInOrder();
        assertEquals("[6 5 2 ]", actual);
        
        tree.deleteByIndex(0);
        actual = tree.toStringInOrder();
        assertEquals("[5 2 ]", actual);
        
        tree.deleteByIndex(1);
        actual = tree.toStringInOrder();
        assertEquals("[5 ]", actual);
    }

}
