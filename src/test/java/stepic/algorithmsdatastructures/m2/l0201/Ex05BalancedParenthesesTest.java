package stepic.algorithmsdatastructures.m2.l0201;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Ex05BalancedParenthesesTest {
    private static class TC {
        String input;
        String expected;

        public TC(String input, String expected) {
            super();
            this.input = input;
            this.expected = expected;
        }

        @Override
        public String toString() {
            return "TC [input=" + input + ", expected=" + expected + "]";
        }

    }
    
    private static List<TC> testCases = new ArrayList<>();
    static {
        testCases.add(new TC("{}", "{}"));
        testCases.add(new TC("{", "{}"));
        testCases.add(new TC("}", "{}"));
        testCases.add(new TC("]", "[]"));
        testCases.add(new TC("([{}])", "([{}])"));
        testCases.add(new TC("[{}])", "([{}])"));
        testCases.add(new TC("([{}]", "([{}])"));
        testCases.add(new TC("}[[([{[]}", "{}[[([{[]}])]]"));
        testCases.add(new TC("{][[[[{}[]", null)); // Test case #9
    }

//    @Test
    public void testMain() {
        fail("Not yet implemented");
    }

    @Test
    public void testMinimalBalancedOf() {
        String actual;
        for (TC tc : testCases) {
            actual = Ex05BalancedParentheses.minimalBalancedOf(tc.input);
            assertEquals(tc.toString(), tc.expected, actual);
        }
    }

}
