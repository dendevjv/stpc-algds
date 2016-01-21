package stepic.algorithmsdatastructures.m4.l0401.kstat;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stepic.algorithmsdatastructures.m4.l0401.kstat.Ex12KStat;

public class Ex12KStatTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testPartition() {
        int[] a = {3, 6, 5, 7, 2, 9, 8, 10, 4, 1};
        int p = Ex12KStat.partition(a, 0, a.length);
        assertEquals(2, p);
    }

    @Test
    public void testKStatDc() {
        int[] a = {3, 6, 5, 7, 2, 9, 8, 10, 4, 15, 13, 16, 11, 14, 1, 12};
        int r = Ex12KStat.kStatDc(a, 11);
        assertEquals(12, r);
    }

}
