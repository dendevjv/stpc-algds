package stepic.algorithmsdatastructures.m3.l0301;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Ex07InsertionSortTest {

    @Test
    public void testMain() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer);
        System.setOut(out );
        
        byte[] buf = "3 1 2".getBytes();
        InputStream in = new ByteArrayInputStream(buf );
        System.setIn(in );
        
        Ex07InsertionSort.main(null);
        String actual = buffer.toString();
        assertEquals("1 2 3 " + System.lineSeparator(), actual);
    }

}
