package stepic.algorithmsdatastructures.m2.l0202;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Ex06EatingFruitsTest {
    private static class TestCase {
        int[] values;
        int limit;
        int expected;

        private TestCase(int[] values, int limit, int expected) {
            this.values = values;
            this.limit = limit;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return "TestCase [values=" + Arrays.toString(values) + ", limit=" + limit + ", expected=" + expected + "]";
        }

    }

    @Test
    public void testCountResult() {
        TestCase[] cases = {
                new TestCase(new int[] {1, 2, 2}, 2, 4),
                new TestCase(new int[] {1, 2, 3, 1, 2, 2}, 3, 6),
                new TestCase(new int[] {2, 2, 2, 2}, 8, 2),
                new TestCase(new int[] {2, 2, 1, 1}, 8, 2)
        };
        for (TestCase tc : cases) {
            int actual = Ex06EatingFruits.countResult(tc.values, tc.limit);
            assertEquals(tc.toString(), tc.expected, actual);
        }
    }

}
