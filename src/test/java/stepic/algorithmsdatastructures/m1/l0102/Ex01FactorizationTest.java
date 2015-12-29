package stepic.algorithmsdatastructures.m1.l0102;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class Ex01FactorizationTest {
    private static Map<Integer, String> expectedResults = new HashMap<Integer, String>();
    static {
        expectedResults.put(2, "2");
        expectedResults.put(3, "3");
        expectedResults.put(4, "2 2");
        expectedResults.put(5, "5");
        expectedResults.put(6, "2 3");
        expectedResults.put(7, "7");
        expectedResults.put(8, "2 2 2");
        expectedResults.put(75, "3 5 5");
        expectedResults.put(211, "211");
    }
    private ByteArrayOutputStream outStream;
    
    @Test
    public void testFactorization() {
        for (Entry<Integer, String> e : expectedResults.entrySet()) {
            int inputNumber = e.getKey();
            
            setUpSystemInput(inputNumber);
            setUpSystemOutput();
            
            Ex01Factorization.factorization(inputNumber);
            
            String actualStringResult = outStream.toString().trim();
            assertEquals(e.getValue(), actualStringResult);
        }
    }

    private void setUpSystemInput(int number) {
        String inputString = number + "\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }
    
    private void setUpSystemOutput() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream ));
    }

}
