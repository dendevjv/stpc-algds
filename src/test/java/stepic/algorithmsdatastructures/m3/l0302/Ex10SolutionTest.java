package stepic.algorithmsdatastructures.m3.l0302;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class Ex10SolutionTest {
    private static String[][] testCases = new String[][] {
            new String[] {"#1", "2 1 3", "1 2 3 ", "2"},
            new String[] {"#2", "2 1 4 3 5", "1 2 3 4 5 ", "2"},
            new String[] {"#3", "3 4 1 2 0 9 7 8 6 5 11 12 13 10 14 18 19 16 17 15", 
                    "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 ", "10"},
            new String[] {"#4", "3 4 1 2 0 9 7 8 6 5 11 12 13 10 14 18 19 16 17 15 99 88", 
                    "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 88 99 ", "10"},
    };

    @Test
    public void testSortAndPrint() {
        for (String[] tc : testCases) {
            
            String input = tc[1];
            int[] data = s2i(input);
            int numSubArrays = Integer.parseInt(tc[3]);
            
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            System.setOut(new PrintStream(buffer));
            Ex10Solution.sortAndPrint(data, numSubArrays);
            
            String expected = tc[2];
            String actual = buffer.toString();
            assertEquals("Failed case " + tc[0], expected, actual);
            
            System.setOut(null);
        }
    }

    private static int[] s2i(String input) {
        String[] tokens = input.split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    
}
