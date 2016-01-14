package stepic.algorithmsdatastructures.m3.l0302;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Ex08PolylineTest {
    private static final String NL = System.lineSeparator();

    @Test
    public void testMain() {
        String input = "4" + NL 
                + "0 0" + NL
                + "1 1" + NL
                + "1 0" + NL
                + "0 1" + NL;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        
        Ex08Polyline.main(null);
        String actual = buffer.toString();
        String expected =  "0 0" + NL 
                + "0 1" + NL
                + "1 0" + NL
                + "1 1" + NL;
        assertEquals(expected, actual);
    }

}
