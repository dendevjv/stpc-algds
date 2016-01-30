package stepic.algorithmsdatastructures.m6.l0603;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AvlTreeTest {
    private AvlTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new AvlTree();
    }

//    @Test
//    public void testAdd() {
//        fail("Not yet implemented");
//    }

    @Test
    public void testToStringInOrder() {
        assertEquals("[]", tree.toStringInOrder());
        
        tree.add(55);
        assertEquals("[55 ]", tree.toStringInOrder());
    }
    
    @Test
    public void testToStringPostOrder() {
        assertEquals("[]", tree.toStringInOrder());
        
        tree.add(55);
        assertEquals("[55 ]", tree.toStringInOrder());
    }
    
    @Test
    public void testGetHeight() {
        AvlTree balanced = new AvlTree();
        balanced.buildBalancedManuallyForTest();
        assertEquals(3, balanced.getHeight());
        
        AvlTree rightList = new AvlTree();
        rightList.addRight(33);
        rightList.addRight(55);
        rightList.addRight(88);
        rightList.addRight(99);
        rightList.addRight(100);
        assertEquals(5, rightList.getHeight());
        
        rightList.rotateLeftShort();
        assertEquals(4, rightList.getHeight());
        
        rightList.rotateLeftShort();
        assertEquals(3, rightList.getHeight());
        
        AvlTree leftList = new AvlTree();
        leftList.addLeft(33);
        leftList.addLeft(55);
        leftList.addLeft(88);
        leftList.addLeft(99);
        leftList.addLeft(100);
        assertEquals(5, leftList.getHeight());
        
        leftList.rotateRightShort();
        assertEquals(4, leftList.getHeight());
        
        leftList.rotateRightShort();
        assertEquals(3, leftList.getHeight());
    }

    @Test
    public void testRotateRightShortOnBalanced() {
        AvlTree balanced = new AvlTree();
        balanced.buildBalancedManuallyForTest(); 
        assertEquals("[22 33 44 55 77 88 99 ]", balanced.toStringInOrder());
        assertEquals("[22 44 33 77 99 88 55 ]", balanced.toStringPostOrder());
        
        balanced.rotateRightShort();
        assertEquals("[22 33 44 55 77 88 99 ]", balanced.toStringInOrder());
        assertEquals("[22 44 77 99 88 55 33 ]", balanced.toStringPostOrder());
        
        balanced.rotateRightShort();
        assertEquals("[22 33 44 55 77 88 99 ]", balanced.toStringInOrder());
        assertEquals("[44 77 99 88 55 33 22 ]", balanced.toStringPostOrder());
    }
    
    @Test
    public void testRotateLeftShortOnBalanced() {
        AvlTree balanced = new AvlTree();
        balanced.buildBalancedManuallyForTest();
        assertEquals("[22 33 44 55 77 88 99 ]", balanced.toStringInOrder());
        assertEquals("[22 44 33 77 99 88 55 ]", balanced.toStringPostOrder());
        
        balanced.rotateLeftShort();
        assertEquals("[22 33 44 55 77 88 99 ]", balanced.toStringInOrder());
        assertEquals("[22 44 33 77 55 99 88 ]", balanced.toStringPostOrder());
        
        balanced.rotateLeftShort();
        assertEquals("[22 33 44 55 77 88 99 ]", balanced.toStringInOrder());
        assertEquals("[22 44 33 77 55 88 99 ]", balanced.toStringPostOrder());
    }
    
    @Test
    public void testRotateLeftShortOnRightList() {
        AvlTree rightList = new AvlTree();
        rightList.addRight(33);
        rightList.addRight(55);
        rightList.addRight(88);
        rightList.addRight(99);
        assertEquals("[33 55 88 99 ]", rightList.toStringInOrder());
        assertEquals("[99 88 55 33 ]", rightList.toStringPostOrder());
        
        rightList.rotateLeftShort();
        assertEquals("[33 55 88 99 ]", rightList.toStringInOrder());
        assertEquals("[33 99 88 55 ]", rightList.toStringPostOrder());
    }
    
    @Test
    public void testRotateRightShortOnLeftList() {
        AvlTree leftList = new AvlTree();
        leftList.addLeft(33);
        leftList.addLeft(55);
        leftList.addLeft(88);
        leftList.addLeft(99);
        assertEquals("[99 88 55 33 ]", leftList.toStringInOrder());
        assertEquals("[99 88 55 33 ]", leftList.toStringPostOrder());   // top=33
        
        leftList.rotateRightShort();
        assertEquals("[99 88 55 33 ]", leftList.toStringInOrder());
        assertEquals("[99 88 33 55 ]", leftList.toStringPostOrder());   // top=55
        
        leftList.rotateRightShort();
        assertEquals("[99 88 55 33 ]", leftList.toStringInOrder());
        assertEquals("[99 33 55 88 ]", leftList.toStringPostOrder());   // top=88
        
        leftList.rotateRightShort();
        assertEquals("[99 88 55 33 ]", leftList.toStringInOrder());
        assertEquals("[33 55 88 99 ]", leftList.toStringPostOrder());   // top=99
    }
}
