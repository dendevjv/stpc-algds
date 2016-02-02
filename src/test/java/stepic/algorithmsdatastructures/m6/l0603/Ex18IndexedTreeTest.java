package stepic.algorithmsdatastructures.m6.l0603;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import stepic.algorithmsdatastructures.tools.SystemOutTester;

public class Ex18IndexedTreeTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
        try (SystemOutTester out = new SystemOutTester()) {
//            String input = "5" + NL +
//                    "1 100" + NL +
//                    "1 200" + NL +
//                    "1 50" + NL +
//                    "2 1" + NL +    
//                    "1 150" + NL;
            String input = "14" + NL +
                    "1 10" + NL +
                    "1 30" + NL +
                    "1 20" + NL +
                    "1 50" + NL +
                    "1 15" + NL +
                    "1 40" + NL +
                    "1 25" + NL +
                    "1 35" + NL +
                    "1 5" + NL +
                    "2 0" + NL +
                    "2 4" + NL +
                    "1 2" + NL +
                    "1 25" + NL +
                    "1 3" + NL;
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf ));
            
            Ex18IndexedTree.main(null);
            
            String actual = out.getOutput();
//            String expected = "0 0 2 1 ";
            String expected = "0 0 1 0 3 1 3 2 8 7 3 8 ";
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }
    
    @Test
    public void testMainInput() {
        Ex18IndexedTree.AvlTree tree = new Ex18IndexedTree.AvlTree();
        
        assertEquals(0, tree.add(10));
        assertEquals(0, tree.add(30));
        assertEquals(1, tree.add(20));
        assertEquals(0, tree.add(50));
        assertEquals(3, tree.add(15));
        assertEquals(1, tree.add(40));
        assertEquals(3, tree.add(25));
        assertEquals(2, tree.add(35));
        assertEquals(8, tree.add(5));
        
        tree.delete(50);
        tree.delete(25);
        assertEquals(7, tree.add(2));
        assertEquals(3, tree.add(25));
        assertEquals(8, tree.add(3));
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
        assertEquals(0, i); //
        i = tree.add(5);
        assertEquals(2, i);
        i = tree.add(3);
        assertEquals(4, i); //
        i = tree.add(1);
        assertEquals(6, i);
        
        tree.delete(4);
        i = tree.add(0);
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
