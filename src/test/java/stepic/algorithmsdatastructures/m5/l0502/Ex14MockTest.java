package stepic.algorithmsdatastructures.m5.l0502;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Ex14MockTest {

    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
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
        
        Ex14Mock.main(null);
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

}
