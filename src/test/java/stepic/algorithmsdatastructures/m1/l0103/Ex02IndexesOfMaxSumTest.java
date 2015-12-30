package stepic.algorithmsdatastructures.m1.l0103;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Ex02IndexesOfMaxSumTest {
    private ByteArrayOutputStream outStream;
    
    private static class TestCase {
        int n;
        int[] arrayA;
        int[] arrayB;
        String expected;
        
        public TestCase(int n, int[] a, int[] b, String expected) {
            if (n != a.length || n != b.length) {
                throw new IllegalArgumentException("Number of elements not equal to array size: n = " + n);
            }
            this.n = n;
            this.arrayA = a;
            this.arrayB = b;
            this.expected = expected;
        }
        
        @Override
        public String toString() {
            return "[n=" + n + ", a=" + Arrays.toString(arrayA) + ", b=" + Arrays.toString(arrayB) + "]";
        }
    }
    
    private static List<TestCase> testCases = new ArrayList<>();
    static {
        testCases.add(new TestCase(1, new int[] {1}, new int[] {1}, "0 0"));
        testCases.add(new TestCase(2, new int[] {1, 0}, new int[] {1, 0}, "0 0"));
        testCases.add(new TestCase(2, new int[] {1, 0}, new int[] {0, 1}, "0 1"));
        testCases.add(new TestCase(2, new int[] {0, 1}, new int[] {0, 1}, "1 1"));
        testCases.add(new TestCase(4, new int[] {4, -8, 6, 0}, new int[] {-10, 3, 1, 1}, "0 1"));
        testCases.add(new TestCase(4, new int[] {7, 6, 5, 4}, new int[] {3, 2, 4, 0}, "0 2"));
        testCases.add(new TestCase(10, new int[] {4, -8, 16, 16, 32, -6, 0, 33, -6, 2}, new int[] {-10, 3, 1, 1, -5, 4, -5, 2, -1, -1}, "4 5"));
        testCases.add(new TestCase(4, new int[] {-1, -2, -3, -4}, new int[] {-5, -2, -1, -2}, "0 2"));
        testCases.add(new TestCase(4, new int[] {2, 1, 2, 3}, new int[] {3, 2, 7, 1}, "0 2"));
        testCases.add(new TestCase(3, new int[] {0, 10, 20}, new int[] {40, 0, 30}, "2 2"));
        testCases.add(new TestCase(4, new int[] {0, 10, 20, 1}, new int[] {40, 0, 1, 30}, "2 3"));
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMain() {
        for (TestCase tc : testCases) {
            setUpSystemInput(tc.n, tc.arrayA, tc.arrayB);
            setUpSystemOutput();
            
            Ex02IndexesOfMaxSum.main(null);
            
            String actualStringResult = outStream.toString().trim();
            assertEquals("TestCase: " + tc, tc.expected, actualStringResult);
        }
    }
    
    private void setUpSystemInput(int n, int[] a, int[] b) {
        final String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(nl);
        for (int v : a) {
            sb.append(v);
            sb.append(" ");
        }
        sb.append(nl);
        for (int v : b) {
            sb.append(v);
            sb.append(" ");
        }
        sb.append(nl);
        String inputString = sb.toString();
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }
    
    private void setUpSystemOutput() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream ));
    }

}
