package stepic.algorithmsdatastructures.m6.l0602;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import stepic.algorithmsdatastructures.tools.SystemOutTester;

public class Ex16TreapVsBinaryTreeTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
        try (SystemOutTester out = new SystemOutTester();) {
            String input = "10" + NL +
                    "5 11" + NL +
                    "18 8" + NL +
                    "25 7" + NL +
                    "50 12" + NL +
                    "30 30" + NL +
                    "15 15" + NL +
                    "20 10" + NL +
                    "22 5" + NL +
                    "40 20" + NL +
                    "45 9" + NL;
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf ));
            Ex16TreapVsBinaryTree.main(null);
            
            String actual = out.getOutput();
            assertEquals("2" + NL, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }

}
