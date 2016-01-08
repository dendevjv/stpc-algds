package stepic.algorithmsdatastructures.m1.l0103;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Ex03IndexOfMinNearestTest {
    private static class TestCase {
        int[] array;
        int number;
        int expectedResult;

        public TestCase(int[] array, int number, int expectedResult) {
            super();
            this.array = array;
            this.number = number;
            this.expectedResult = expectedResult;
        }

        @Override
        public String toString() {
            return "TestCase {array=" + Arrays.toString(array) + ", number=" + number +
                    ", expected=" + expectedResult + "}";
        }
    }
    
    private static int[] array3 = new int[] {10, 20, 30};
    private static int[] array4 = new int[] {1, 3, 7, 11};
    private static int[] array5 = new int[] {1, 1, 3, 3, 7, 7, 11, 11};
    private static TestCase[] testCases = new TestCase[] {
            new TestCase(array4, 1, 0),
            new TestCase(array4, 2, 0),     // e=0  a=1
            new TestCase(array4, 3, 1),
            new TestCase(array4, 4, 1),
            new TestCase(array4, 5, 1),
            new TestCase(array4, 6, 2),     // e=2  a=1
            new TestCase(array4, 7, 2),
            new TestCase(array4, 8, 2),
            new TestCase(array4, 9, 2),
            new TestCase(array4, 10, 3),
            new TestCase(array4, 11, 3),
            new TestCase(array4, 12, 3),
            new TestCase(array3, 9, 0),
            new TestCase(array3, 15, 0),
            new TestCase(array3, 35, 2),
            new TestCase(array5, 1, 0),
            new TestCase(array5, 2, 0),
            new TestCase(array5, 3, 2),
            new TestCase(array5, 4, 2),
            new TestCase(array5, 5, 2),
            new TestCase(array5, 6, 4),
            new TestCase(array5, 7, 4),
    };
//
//    @Before
//    public void setUp() throws Exception {
//    }

    @Test
    public void testFindMinimalNearest() {
        int actual;
        for (TestCase tc : testCases) {
            actual = Ex03IndexOfMinNearest.findMinimalNearest(tc.array, tc.number);
            assertEquals(tc.toString(), tc.expectedResult, actual);
        }
    }

}
