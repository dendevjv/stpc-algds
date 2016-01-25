package stepic.algorithmsdatastructures.m5.l0502;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import stepic.algorithmsdatastructures.tools.RandomStringGenerator;

public class StringSetImplRandomTest {
    @Test
    public void testRandom() {
        final int numTests = 1000;
        List<String> data = new ArrayList<>();
        RandomStringGenerator rsg = new RandomStringGenerator(50);
        for (int i = 0; i < numTests; i++) {
            data.add(rsg.next());
        }
        
        Set<String> refSet = new HashSet<>();
        StringSet actSet = new StringSetImpl();
        
        Random randomOperations = new Random();
        boolean expected, actual;
        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i);
            switch (randomOperations.nextInt(3)) {
            case 0: // +
                expected = refSet.add(item);
                actual = actSet.add(item);
                assertEquals("Failed on adding data:\n" + "Set: " + actSet.toString() + "\n" + "Trying to add: " + item + "; ", 
                        expected, actual);
                break;
            case 1: // -
                refSet.remove(item);
                actSet.delete(item);
                assertFalse("Failed on deleting data:\n" + "Set: " + actSet.toString() + "\n" + "Trying to delete: " + item + "; ",
                        actSet.contains(item));
                break;
            case 2: // ?
                expected = refSet.contains(item);
                actual = actSet.contains(item);
                assertEquals("Failed on quering data:\n" + "Set: " + actSet.toString() + "\n" + "Trying to query: " + item + "; ", 
                        expected, actual);
                break;
            }
        }
    }
}
