package stepic.algorithmsdatastructures.m5.l0502;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringSetImplTest {
    private StringSet set;

    @Before
    public void setUp() throws Exception {
        set = new StringSetImpl();
    }

    @Test
    public void testAdd() {
        assertFalse(set.contains("11"));
        set.add("11");
        assertTrue(set.contains("11"));
        
        assertFalse(set.contains("22"));
        set.add("22");
        assertTrue(set.contains("22"));
        
        set.add("33");
        set.add("44");
        set.add("55");
        set.add("66");
        set.add("77");
        set.add("88");
        set.add("99");
        
        assertTrue(set.contains("11"));
        assertTrue(set.contains("22"));
        assertTrue(set.contains("33"));
        assertTrue(set.contains("44"));
        assertTrue(set.contains("55"));
        assertTrue(set.contains("66"));
        assertTrue(set.contains("77"));
        assertTrue(set.contains("88"));
        assertTrue(set.contains("99"));
    }

    @Test
    public void testDelete() {
        assertFalse(set.contains("11"));
        set.add("11");
        assertTrue(set.contains("11"));
        set.delete("11");
        assertFalse(set.contains("11"));
        
        set.add("11");
        set.add("22");
        set.add("33");
        set.add("44");
        set.add("55");
        set.add("66");
        set.add("77");
        set.add("88");
        set.add("99");
        assertTrue(set.contains("11"));
        assertTrue(set.contains("22"));
        assertTrue(set.contains("33"));
        assertTrue(set.contains("44"));
        assertTrue(set.contains("55"));
        assertTrue(set.contains("66"));
        assertTrue(set.contains("77"));
        assertTrue(set.contains("88"));
        assertTrue(set.contains("99"));
        
        set.delete("11");
        assertFalse(set.contains("11"));
        set.delete("22");
        assertFalse(set.contains("22"));
        set.delete("33");
        assertFalse(set.contains("33"));
        set.delete("44");
        assertFalse(set.contains("44"));
        set.delete("55");
        assertFalse(set.contains("55"));
        set.delete("66");
        assertFalse(set.contains("66"));
        set.delete("77");
        assertFalse(set.contains("77"));
        set.delete("88");
        assertFalse(set.contains("88"));
        set.delete("99");
        assertFalse(set.contains("99"));
    }

    @Test
    public void testToString() {
        assertEquals("[]", set.toString());
        
        set.add("first");
        set.add("second");
        assertEquals("[first, second]", set.toString());
    }
}
