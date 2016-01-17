package stepic.algorithmsdatastructures.m3.l0302;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Ex09SegmentsTest {
    private static class TestCase {
        int[] data;
        int expectedLength;

        public TestCase(int[] data, int expectedLength) {
            this.data = data;
            this.expectedLength = expectedLength;
        }

        @Override
        public String toString() {
            return "TestCase {data=" + Arrays.toString(data) + ", expectedLength=" + expectedLength + "}";
        }
    }
    
    private static TestCase[] testCases = new TestCase[] {
          new TestCase(new int[] {1, 3, 4, 6}, 4),
          new TestCase(new int[] {1, 3, 2, 4}, 2),
          new TestCase(new int[] {1, 4, 2, 4}, 1),
          new TestCase(new int[] {1, 5, 2, 4}, 2),
          new TestCase(new int[] {1, 4, 1, 3}, 1),
          new TestCase(new int[] {1, 4, 1, 3, 1, 2}, 1),
          new TestCase(new int[] {1, 5, 1, 3, 4, 5,  1, 2, 1, 4}, 0),
          new TestCase(new int[] {1, 2, 2, 3, 3, 4}, 3),
          new TestCase(new int[] {1, 5, 2, 5, 3, 5}, 1),
          new TestCase(new int[] {1, 4, 7, 8, 2, 5}, 3),
          new TestCase(new int[] {1, 2, 1, 2}, 0),
          new TestCase(new int[] {1, 5, 2, 4}, 2),
          new TestCase(new int[] {2, 5, 7, 9, 8, 10, 6, 8, 1, 4}, 4),
          new TestCase(new int[] {3, 5, 3, 4, 4, 5, 1, 2}, 1),
          new TestCase(new int[] {1, 2, 3, 5, 3, 4, 4, 5, 1, 2}, 0),
  };

    @Test
    public void testCalculateOneLayerLength() {
        for (TestCase tc : testCases) {
            java.util.List<Ex09Segments.SegmentPoint> points = new java.util.ArrayList<>(tc.data.length * 2);
            for (int i = 0; i < tc.data.length; i += 2) {
                points.add(new Ex09Segments.SegmentPoint(tc.data[i], true));
                points.add(new Ex09Segments.SegmentPoint(tc.data[i + 1], false));
            }
            int actualLenght = Ex09Segments.calculateOneLayerLength(points);
            assertEquals("Failed " + tc.toString() + ";", tc.expectedLength, actualLenght);
        }
    }

}
