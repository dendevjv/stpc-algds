/*
    Дан фрагмент последовательности скобок, состоящей из символов (){}[].
    Требуется определить, возможно ли продолжить фрагмент в обе стороны, получив корректную последовательность.
    Если возможно - выведите минимальную корректную последовательность, иначе - напечатайте "IMPOSSIBLE".
    Максимальная длина строки 10^6 символов.
    Sample Input 1:
        }[[([{[]}
    Sample Output 1:
        {}[[([{[]}])]]
    Sample Input 2:
        {][[[[{}[]
    Sample Output 2:
        IMPOSSIBLE
 */
package stepic.algorithmsdatastructures.m2.l0201;

import java.util.Arrays;

public class Ex05BalancedParentheses {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        String s = in.nextLine();
        String balanced = minimalBalancedOf(s);
        System.out.println((balanced != null) ? balanced : "IMPOSSIBLE");
        in.close();
    }
    
    private static class StackChar {
        private static final int INITIAL_CAPACITY = 2;
        private char[] cbuf;
        private int tail = -1;
        private int head;
        private int size;
        
        private StackChar() {
            cbuf = new char[INITIAL_CAPACITY];
        }
        
        private void push(char ch) {
            ensureCapacity(size + 1);
            cbuf[++tail] = ch;
            size++;
        }
        
        private void pushFront(char ch) {
            head--;
            head = (head < 0) ? cbuf.length - 1 : head;
            cbuf[head] = ch;
            size++;
        }
        
        private char pop() {
            size--;
            return cbuf[tail--];
        }

        private void ensureCapacity(int c) {
            if (c > cbuf.length) {
                if (head == 0) { 
                    cbuf = Arrays.copyOf(cbuf, cbuf.length * 2);
                } else {
                    char[] tmp = new char[cbuf.length * 2];
                    int current = head;
                    for (int i = 0; i < size; i++) {
                        tmp[i] = cbuf[current];
                        current = (current + 1) % cbuf.length;
                    }
                    cbuf = tmp;
                    head = 0;
                    tail = size;
                }
            }
        }
        
        private boolean isEmpty() { return size == 0; }
        
        @Override
        public String toString() {
            if (isEmpty()) { return ""; }
            StringBuilder sb = new StringBuilder();
            int c = head;
            for (int i = 0; i < size; i++) {
                sb.append(cbuf[c]);
                c = (c + 1) % cbuf.length;
            }
            return sb.toString();
        }
    }

    static String minimalBalancedOf(String s) {
        StackChar st = new StackChar();
        StackChar prefix = new StackChar();
        StackChar suffix = new StackChar();
        char opening;
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '(' || p == '{' || p == '[') {     // opening
                st.push(p);
            } else {                                    // closing
                if (st.isEmpty()) {     // unbalanced
                    if (p == ')') {
                        prefix.pushFront('(');
                    } else if (p == '}') {
                        prefix.pushFront('{');
                    } else if (p == ']') {
                        prefix.pushFront('[');
                    }
                } else {
                    opening = st.pop();
                    if (p == ')' && opening != '(' 
                            || p == '}' && opening != '{' 
                            || p == ']' && opening != '[') {
                        return null; // can not be balanced // TODO Check this case
                    }
                }
            }
        }
        // Check that the stack is not empty
        while (!st.isEmpty()) {
            opening = st.pop();
            if (opening == '(') {
                suffix.push(')');
            } else if (opening == '{') {
                suffix.push('}');
            } else if (opening == '[') {
                suffix.push(']');
            } else {
                return null; // TODO Check this case
            }
        }
        
        // Return balanced and  modified if necessary string OR null
        String balanced = prefix.toString() + s + suffix.toString();
        return balanced;
    }

}
