package stepic.algorithmsdatastructures.m6.l0602;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TreapModelTest {
    private TreapModel treap;

    @Before
    public void setUp() throws Exception {
        treap = new TreapModel();
    }

    @Test
    public void testAdd() {
        treap.add(5, 14);
        assertEquals("[{5;14} ]", treap.toStringInOrder());
        assertEquals("[{5;14} ]", treap.toStringPreOrder());
        
        treap.add(2, 11);
        assertEquals("[{2;11} {5;14} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} ]", treap.toStringPreOrder());
        
        treap.add(13, 12);
        assertEquals("[{2;11} {5;14} {13;12} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {13;12} ]", treap.toStringPreOrder());
        
        treap.add(0, 6);
        assertEquals("[{0;6} {2;11} {5;14} {13;12} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {13;12} ]", treap.toStringPreOrder());
        
        treap.add(3, 8);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {13;12} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} ]", treap.toStringPreOrder());
        
        treap.add(7, 9);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} ]", treap.toStringPreOrder());
        
        treap.add(19, 10);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {19;10} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} ]", treap.toStringPreOrder());
        
        treap.add(15, 7);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {15;7} {19;10} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} {15;7} ]", treap.toStringPreOrder());
        
        treap.add(20, 5);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {15;7} {19;10} {20;5} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} {15;7} {20;5} ]", treap.toStringPreOrder());
        
        treap.add(14, 2);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {14;2} {15;7} {19;10} {20;5} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} {15;7} {14;2} {20;5} ]", treap.toStringPreOrder());
        
        treap.add(18, 3);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {14;2} {15;7} {18;3} {19;10} {20;5} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} {15;7} {14;2} {18;3} {20;5} ]", treap.toStringPreOrder());
        
        treap.add(17, 0);
        assertEquals("[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {14;2} {15;7} {17;0} {18;3} {19;10} {20;5} ]", treap.toStringInOrder());
        assertEquals("[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} {15;7} {14;2} {18;3} {17;0} {20;5} ]", treap.toStringPreOrder());
    }
    
    @Test
    public void testAddInRandomOrder() {
        int[] data = {5, 14, 2, 11, 13, 12, 0, 6, 3, 8, 7, 9, 19, 10, 15, 7, 20, 5, 14, 2, 18, 3, 17, 0};
        List<NodeData> paired = toPaires(data);
        for (int i = 0; i < paired.size(); i++) {
            TreapModel treapInstance = new TreapModel();
            Collections.shuffle(paired);
            for (NodeData pair : paired) {
                treapInstance.add(pair.value, pair.priority);
            }
            assertEquals("Failed on test data: " + paired.toString(), 
                    "[{0;6} {2;11} {3;8} {5;14} {7;9} {13;12} {14;2} {15;7} {17;0} {18;3} {19;10} {20;5} ]", treapInstance.toStringInOrder());
            assertEquals("Failed on test data: " + paired.toString(), 
                    "[{5;14} {2;11} {0;6} {3;8} {13;12} {7;9} {19;10} {15;7} {14;2} {18;3} {17;0} {20;5} ]", treapInstance.toStringPreOrder());
        }
    }
    
    @Test
    public void testGetHeight() {
        assertEquals(0, treap.getHeight());
        
        treap.add(5, 14);
        assertEquals(1, treap.getHeight());
        
        treap.add(2, 11);
        assertEquals(2, treap.getHeight());
        treap.add(13, 12);
        assertEquals(2, treap.getHeight());
        
        treap.add(0, 6);
        assertEquals(3, treap.getHeight());
        treap.add(3, 8);
        assertEquals(3, treap.getHeight());
        treap.add(7, 9);
        assertEquals(3, treap.getHeight());
        treap.add(19, 10);
        assertEquals(3, treap.getHeight());
        
        treap.add(15, 7);
        assertEquals(4, treap.getHeight());
        treap.add(20, 5);
        assertEquals(4, treap.getHeight());
        
        treap.add(14, 2);
        assertEquals(5, treap.getHeight());
        treap.add(18, 3);
        assertEquals(5, treap.getHeight());
        
        treap.add(17, 0);
        assertEquals(6, treap.getHeight());
    }

    private static List<NodeData> toPaires(int[] data) {
        List<NodeData> list = new ArrayList<>(data.length / 2);
        for (int i = 0; i < data.length; i += 2) {
            NodeData pair = new NodeData(data[i], data[i + 1]);
            list.add(pair);
        }
        return list;
    }
    
    private static class NodeData {
        private int value;
        private int priority;

        private NodeData(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "{" + value + ";" + priority + "}";
        }
    }

//    @Test
//    public void testMerge() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testSplit() {
//        fail("Not yet implemented");
//    }


}
