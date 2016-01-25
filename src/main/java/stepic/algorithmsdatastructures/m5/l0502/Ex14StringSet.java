/*
Реализуйте структуру данных типа "множество строк" на основе динамической хеш-таблицы 
с открытой адресацией. Хранимые строки непустые и состоят из строчных латинских букв. 
Начальный размер таблицы должен быть равным 8-ми. Перехеширование выполняйте в случае, 
когда коэффициент заполнения таблицы достигает 3/4.

Структура данных должна поддерживать операции добавления строки в множество, 
удаления строки из множества и проверки принадлежности данной строки множеству.

Для разрешения коллизий используйте квадратичное пробирование. 
i-ая проба
g(k,i) = g(k,i-1) + i(mod m). m - степень двойки

Каждая строка входных данных задает одну операцию над множеством. 
Запись операции состоит из типа операции и следующей за ним через пробел строки, 
над которой проводится операция.

Тип операции  – один из трех символов:
   +  означает добавление данной строки в множество;
   -  означает удаление  строки из множества;  
   ?  означает проверку принадлежности данной строки множеству.
При добавлении элемента в множество НЕ ГАРАНТИРУЕТСЯ, что он отсутствует в этом множестве. 
При удалении элемента из множества НЕ ГАРАНТИРУЕТСЯ, что он присутствует в этом множестве.

Программа должна вывести для каждой операции одну из двух строк OK или FAIL, 
в зависимости от того, встречается ли данное слово в нашем множестве. 

Sample Input:
    + hello
    + bye
    ? bye
    + bye
    - bye
    ? bye
    ? hello
Sample Output:
    OK
    OK
    OK
    FAIL
    OK
    FAIL
    OK

 */
package stepic.algorithmsdatastructures.m5.l0502;

public class Ex14StringSet {

    public static void main(String[] args) {
        StringSet set = new StringSet();
        java.util.Scanner in = new java.util.Scanner(System.in);
        boolean ok = false;
        String line, data;
        while (in.hasNextLine()) {
            line = in.nextLine();
            data = line.substring(2);
            switch (line.charAt(0)) {
            case '+':
                ok = set.add(data);
                break;
            case '-':
                ok = set.delete(data);
                break;
            case '?':
                ok = set.contains(data);
                break;
            }
            System.out.println(ok ? "OK" : "FAIL");
        }
        in.close();
    }
    
    private static class StringSet {
        private static final int INITIAL_TABLE_SIZE = 8;
        private static final String DELETED = "DELETED";
        private static final double REHASH_LOAD_FACTOR = 0.75;
        
        private String[] table;
        private int size;
        
        StringSet() {
            table = new String[INITIAL_TABLE_SIZE];
            size = 0;
        }

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

        public boolean delete(String s) {
            for (int i = 0; i < table.length; i++) {
                int j = innerHash(s, i, table.length);
                if (table[j] == null) {
                    return false;
                } else if (table[j] == DELETED) {
                    continue;
                } else if (table[j].equals(s)) {
                    table[j] = DELETED;
                    size--;
                    return true;
                }
            }
            return false;
        }

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

}
