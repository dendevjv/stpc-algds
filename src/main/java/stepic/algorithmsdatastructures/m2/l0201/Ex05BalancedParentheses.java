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
        private static final int INITIAL_CAPACITY = 16;
        private char[] cbuf;
        private int top = -1;
        
        private StackChar() {
            cbuf = new char[INITIAL_CAPACITY];
        }
        
        private void push(char ch) {
            ensureCapacity(top + 2);
            cbuf[++top] = ch;
        }
        
        private char pop() {
            return cbuf[top--];
        }

        private void ensureCapacity(int c) {
            if (c > cbuf.length) {
                cbuf = Arrays.copyOf(cbuf, cbuf.length * 2);
            }
        }
        
        private boolean isEmpty() { return top == -1; }
        
        @Override
        public String toString() {
            if (isEmpty()) { return ""; }
            return String.valueOf(cbuf, 0, top + 1);
        }
        
        public String toStringReversed() {
            if (isEmpty()) { return ""; }
            StringBuilder sb = new StringBuilder(String.valueOf(cbuf, 0, top + 1));
            sb.reverse();
            return sb.toString();
        }
    }

    static String minimalBalancedOf(String input) {
        StackChar st = new StackChar();
        StackChar prefix = new StackChar();
        StackChar suffix = new StackChar();
        char opening;
        for (int i = 0; i < input.length(); i++) {
            char p = input.charAt(i);
            if (p == '(' || p == '{' || p == '[') {     // opening
                st.push(p);
            } else {                                    // closing
                if (st.isEmpty()) {     // unbalanced
                    if (p == ')') {
                        prefix.push('(');
                    } else if (p == '}') {
                        prefix.push('{');
                    } else if (p == ']') {
                        prefix.push('[');
                    }
                } else {
                    opening = st.pop();
                    if (p == ')' && opening != '(' 
                            || p == '}' && opening != '{' 
                            || p == ']' && opening != '[') {
                        return null; // non balanced pair - Test case #9
                    }
                }
            }
        }
        while (!st.isEmpty()) {
            opening = st.pop();
            if (opening == '(') {
                suffix.push(')');
            } else if (opening == '{') {
                suffix.push('}');
            } else if (opening == '[') {
                suffix.push(']');
            } 
        }
        
        return prefix.toStringReversed() + input + suffix.toString();
    } // end of  minimalBalancedOf

}
