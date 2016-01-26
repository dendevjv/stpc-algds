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

}
