package stepic.algorithmsdatastructures.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class SystemOutTesterTest {

    @Test
    public void testGetOutput() {
        String actual = null;
        
        try (SystemOutTester tester = new SystemOutTester();) { 
            System.out.print("Hello!");
            actual = tester.getOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        assertEquals("Hello!", actual);
    }

}
