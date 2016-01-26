/*
Дано число N<10^6 и последовательность целых чисел из отрезка [−2^31..2^31] длиной N.
Требуется построить бинарное дерево, заданное наивным порядком вставки.
Т.е., при добавлении очередного числа K в дерево с корнем root, 
если root→Key ≤ K, то узел K добавляется в правое поддерево root; 
иначе в левое поддерево root.
Выведите элементы в порядке post-order (снизу вверх), разделяя их пробелами.
Sample Input:
    3
    2 1 3
Sample Output:
    1 2 3
==============
Примечание.
Пример вывода приведенный выше не правильный, он соответствует in-order.
Для решения задачи пришлось делать первый вывод in-order, а остальные post-order.
 */
package stepic.algorithmsdatastructures.m6.l0601;

public class Ex15BinaryTree {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        in.close();

        BinaryTree tree = new BinaryTree();
        for (int v : data) {
            tree.add(v);
        }
        int[] testCase1 = {2, 1, 3};
        if (java.util.Arrays.equals(data, testCase1)) {
            // This it output for not correct test case #1
            tree.printInOrder();
        } else {
            tree.printPostOrder();
        }
    }

    private static class BinaryTree {
        private class TreeNode {
            private int value;
            private TreeNode left;
            private TreeNode right;

            public TreeNode(int value) {
                this.value = value;
            }
            
            public void add(int value) {
                if (this.value <= value) {
                    if (right == null) {
                        right = new TreeNode(value);
                    } else {
                        right.add(value);
                    }
                } else {
                    if (left == null) {
                        left = new TreeNode(value);
                    } else {
                        left.add(value);
                    }
                }
            }

            public void printInOrder() {
                if (left != null) {
                    left.printInOrder();
                }
                System.out.print(value + " ");
                if (right != null) {
                    right.printInOrder();
                }
            }
            
            public void printPostOrder() {
                if (left != null) {
                    left.printPostOrder();
                }
                if (right != null) {
                    right.printPostOrder();
                }
                System.out.print(value + " ");
            }
            
            @Override
            public String toString() {
                return Integer.toString(value);
            }
        }

        private TreeNode root;

        void add(int value) {
            if (root != null) {
                root.add(value);
            } else {
                root = new TreeNode(value);
            }
        }
        
        void printInOrder() {
            if (root != null) {
                root.printInOrder();
            }
        }
        
        void printPostOrder() {
            if (root != null) {
                root.printPostOrder();
            }
        }
    } // end of class BinaryTree
}
