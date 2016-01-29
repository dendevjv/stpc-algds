package stepic.algorithmsdatastructures.m6.l0601;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stepic.algorithmsdatastructures.tools.SystemOutTester;

public class BinaryTreeTest {
    private BinaryTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinaryTree();
    }

    @Test
    public void testPrintInOrder() {
        tree.add(4);
        tree.add(6);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(5);
        tree.add(7);
        
        try (SystemOutTester out = new SystemOutTester();) {
            String expected = "1 2 3 4 5 6 7 ";
            tree.printInOrder();
            String actual = out.getOutput();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }
    
    @Test
    public void testPrintPostOrder() {
        tree.add(4);
        tree.add(6);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(5);
        tree.add(7);
        
        try (SystemOutTester out = new SystemOutTester();) {
            String expected = "1 3 2 5 7 6 4 ";
            tree.printPostOrder();
            String actual = out.getOutput();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }

    @Test
    public void testGetHeight() {
        assertEquals(0, tree.getHeight());

        tree.add(5);
        assertEquals(1, tree.getHeight());

        tree.add(2);
        assertEquals(2, tree.getHeight());
        tree.add(13);
        assertEquals(2, tree.getHeight());

        tree.add(0);
        assertEquals(3, tree.getHeight());
        tree.add(3);
        assertEquals(3, tree.getHeight());
        tree.add(7);
        assertEquals(3, tree.getHeight());
        tree.add(19);
        assertEquals(3, tree.getHeight());

        tree.add(15);
        assertEquals(4, tree.getHeight());
        tree.add(20);
        assertEquals(4, tree.getHeight());

        tree.add(14);
        assertEquals(5, tree.getHeight());
        tree.add(18);
        assertEquals(5, tree.getHeight());

        tree.add(17);
        assertEquals(6, tree.getHeight());

        tree.add(16);
        assertEquals(7, tree.getHeight());
    }
}
