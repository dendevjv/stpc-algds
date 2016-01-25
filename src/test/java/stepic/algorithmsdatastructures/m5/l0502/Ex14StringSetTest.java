package stepic.algorithmsdatastructures.m5.l0502;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Ex14StringSetTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testMainTheTask() {
        String input = "+ hello" + NL
                    + "+ bye" + NL
                    + "? bye" + NL
                    + "+ bye" + NL
                    + "- bye" + NL
                    + "? bye" + NL
                    + "? hello" + NL;
        
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf ));
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        Ex14StringSet.main(null);
        String actual = buffer.toString();
        String expected = "OK" + NL
                        + "OK" + NL
                        + "OK" + NL
                        + "FAIL" + NL
                        + "OK" + NL
                        + "FAIL" + NL
                        + "OK" + NL;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMainWithDeletion() {
        String input = "+ hello" + NL
                + "+ bye" + NL
                + "? bye" + NL
                + "+ bye" + NL
                + "- bye" + NL
                + "? bye" + NL
                + "- bye" + NL
                + "? hello" + NL;
        
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf ));
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        Ex14StringSet.main(null);
        String actual = buffer.toString();
        String expected = "OK" + NL
                + "OK" + NL
                + "OK" + NL
                + "FAIL" + NL
                + "OK" + NL
                + "FAIL" + NL
                + "FAIL" + NL
                + "OK" + NL;
        assertEquals(expected, actual);
    }

}
