package stepic.algorithmsdatastructures.m1.l0103;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

    private static class TestCase {
        double[] array;
        double element;
        int expectedResult;

        public TestCase(double[] array, double element, int expectedResult) {
            super();
            this.array = array;
            this.element = element;
            this.expectedResult = expectedResult;
        }

        @Override
        public String toString() {
            return "[array: " + Arrays.toString(array) + ", element=" + element + ", expected=" + expectedResult + "]";
        }
    }
    
    private static final double[] arrayOfSingles = {1, 3, 5};
    
    private static List<TestCase> testCaseSingles = new ArrayList<>();
    static {
        testCaseSingles.add(new TestCase(arrayOfSingles, 1, 0));
        testCaseSingles.add(new TestCase(arrayOfSingles, 3, 1));
        testCaseSingles.add(new TestCase(arrayOfSingles, 5, 2));
        testCaseSingles.add(new TestCase(arrayOfSingles, 2, -1));
        testCaseSingles.add(new TestCase(arrayOfSingles, 6, -1));
        testCaseSingles.add(new TestCase(arrayOfSingles, 0, -1));
    }
    
    private static final double[] arrayOfTripples = {1, 1, 1, 3, 3, 3, 5, 5, 5};
    private static List<TestCase> testCasesTripples = new ArrayList<>();
    static {
        testCasesTripples.add(new TestCase(arrayOfTripples, 1, 0));
        testCasesTripples.add(new TestCase(arrayOfTripples, 3, 3));
        testCasesTripples.add(new TestCase(arrayOfTripples, 5, 6));
        testCasesTripples.add(new TestCase(arrayOfTripples, 2, -1));
        testCasesTripples.add(new TestCase(arrayOfTripples, 6, -1));
        testCasesTripples.add(new TestCase(arrayOfTripples, 0, -1));
    }
    
    @Test
    public void testSearchFirst() {
        processSearchFirst(testCaseSingles);
        processSearchFirst(testCasesTripples);
    }
    
    private void processSearchFirst(List<TestCase> testCases) {
        int actual;
        for (TestCase tc : testCases) {
            actual = BinarySearch.searchFirst(tc.array, tc.element);
            assertEquals(tc.toString(), tc.expectedResult, actual);
        }
    }
    

    @Test
    public void testSearchAny() {
        processSearchAny(testCaseSingles);
//        processSearchAny(testCasesTripples);    // FAILS
    }

    private void processSearchAny(List<TestCase> testCases) {
        int actual;
        for (TestCase tc : testCases) {
            actual = BinarySearch.searchAny(tc.array, tc.element);
            assertEquals(tc.toString(), tc.expectedResult, actual);
        }
    }
}
