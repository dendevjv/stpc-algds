package stepic.algorithmsdatastructures.m5.l0502;

/**
 * Implements set of strings using dynamic hash-table.
 * Strings are non-empty and contain lower case latin letters only. 
 * The hash table will be rehashed when q=3/4.
 */
public class StringSetImpl implements StringSet {
    private static final int INITIAL_TABLE_SIZE = 8;
    private static final String DELETED = "DELETED";
    private static final double REHASH_LOAD_FACTOR = 0.75;
    
    private String[] table;
    private int size;
    
    StringSetImpl() {
        table = new String[INITIAL_TABLE_SIZE];
        size = 0;
    }

    @Override
    public boolean add(String s) {
        if (insert(table, s)) {
            size++;
            double loadFactor = ((double) size) / table.length;
            if (loadFactor >= REHASH_LOAD_FACTOR) {
                rehash();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(String s) {
        for (int i = 0; i < table.length; i++) {
            int j = innerHash(s, i, table.length);
            if (table[j] == null) {
                return;
            } else if (table[j] == DELETED) {
                continue;
            } else if (table[j].equals(s)) {
                table[j] = DELETED;
                size--;
                return;
            }
        }
    }

    @Override
    public boolean contains(String s) {
        for (int i = 0; i < table.length; i++) {
            int j = innerHash(s, i, table.length);
            if (table[j] == null) {
                return false;
            } else if (table[j] == DELETED) {
                continue;
            } else if (table[j].equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean notFirst = false;
        sb.append("[");
        for (int i = 0; i < table.length; i++) {
            if (cellIsOccupied(i)) {
                if (notFirst) {
                    sb.append(", ");
                } else {
                    notFirst = true;
                }
                sb.append(table[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    private boolean insert(String[] t, String s) {
        for (int i = 0; i < t.length; i++) {
            int j = innerHash(s, i, t.length);
            if (t[j] == null || t[j] == DELETED) {
                t[j] = s;
                return true;
            } else if (t[j].equals(s)) {
                return false;
            }
        }
        throw new RuntimeException("Hash table overflow: Can not insert new value");
    }

    private void rehash() {
        String[] newTable = new String[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            if (cellIsOccupied(i)) {
                insert(newTable, table[i]);
            }
        }
        table = newTable;
    }
    
    private boolean cellIsOccupied(int j) {
        return table[j] != null && table[j] != DELETED;
    }
    
    private int innerHash(String s, int i, int m) {
        int h = s.hashCode();
        h = (h < 0) ? -h : h;
        for (int j = 1; j <= i; j++) {
            h = h + j; 
        }
        return h % m;
    }

}
    
