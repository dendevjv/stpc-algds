package stepic.algorithmsdatastructures.m6.l0603;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import stepic.algorithmsdatastructures.tools.SystemOutTester;

public class Ex17AvlTreeTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMain() {
        try (SystemOutTester out = new SystemOutTester()) {
            String input = "2 4 6 -2";
//            String input = "1 2 3 4 5 6 7 -4 -5 -6 -3 -1";
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf ));
            
            Ex17AvlTree.main(null);
            
            String actual = out.getOutput();
            assertEquals("2" + System.lineSeparator(), actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception: " + e);
        }
    }

}
