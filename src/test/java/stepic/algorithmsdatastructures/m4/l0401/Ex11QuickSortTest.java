package stepic.algorithmsdatastructures.m4.l0401;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Ex11QuickSortTest {

    @Test
    public void testMain() {
        String[][] testCases = new String[][] {
                new String[] {"3 0 2 1 5 4 21 4 6 5", "21 "},
        };
        for (String[] tc : testCases) {
            String input = tc[0];
            byte[] buf = input.getBytes();
            System.setIn(new ByteArrayInputStream(buf ));
            
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer));
            
            Ex11QuickSort.main(null);
            String actual = buffer.toString();
            assertEquals("Failed case: " + tc[0], tc[1], actual);
        }
    }

}
