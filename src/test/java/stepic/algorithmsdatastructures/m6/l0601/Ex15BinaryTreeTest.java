package stepic.algorithmsdatastructures.m6.l0601;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import stepic.algorithmsdatastructures.tools.SystemOutTester;

public class Ex15BinaryTreeTest {
    private static final String NL = System.lineSeparator();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMainNotCorrectFirstTest() {
        try (SystemOutTester tester = new SystemOutTester()) {
            String input = "3" + NL + "2 1 3";
            
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            
            Ex15BinaryTree.main(null);
            
            String expected = "1 2 3 ";
            String actual = tester.getOutput();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }

    @Test
    public void testMain() {
        try (SystemOutTester tester = new SystemOutTester()) {
            String input = "7" + NL + "4 2 6 1 3 5 7";
            
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            
            Ex15BinaryTree.main(null);
            
            String expected = "1 3 2 5 7 6 4 ";
            String actual = tester.getOutput();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }
}
