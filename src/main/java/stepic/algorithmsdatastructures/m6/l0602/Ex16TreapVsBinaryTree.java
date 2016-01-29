/*
    Дано число N<10^6 и последовательность пар целых чисел из [−2^31..2^31] длиной N.
    Постройте декартово дерево из N узлов, характеризующихся парами чисел {Xi,Yi}.
    Каждая пара чисел {Xi,Yi} определяет ключ Xi и приоритет Yi в декартовом дереве.
    Добавление узла в декартово дерево выполняйте второй более эффективной версией алгоритма:
    При добавлении узла (x, y) выполняйте спуск по ключу до узла P с меньшим приоритетом. 
    Затем разбейте найденное поддерево по ключу x так, чтобы в первом поддереве все ключи 
    меньше x, а во втором больше или равны x. Получившиеся два дерева сделайте дочерними 
    для нового узла (x, y). Новый узел вставьте на место узла P.
    Построите также наивное дерево поиска по ключам Xi.
    Вычислите разницу глубин наивного дерева поиска и декартового дерева.
    
    Sample Input:
        10
        5 11
        18 8
        25 7
        50 12
        30 30
        15 15
        20 10
        22 5
        40 20
        45 9
    Sample Output:
        2
 */
package stepic.algorithmsdatastructures.m6.l0602;

public class Ex16TreapVsBinaryTree {

    public static void main(String[] args) {
        Treap treap = new Treap();
        NaiveBinaryTree naiveTree = new NaiveBinaryTree();
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            int priority = in.nextInt();
            treap.add(value, priority);
            naiveTree.add(value);
        }
        in.close();
        int treapHeight = treap.getHeight();
        int naiveTreeHeight = naiveTree.getHeight();
        System.out.println(naiveTreeHeight - treapHeight);
    }

    private static class Treap {
        private class Node {
            int value;
            int priority;
            Node left;
            Node right;

            Node(int value, int priority) {
                this.value = value;
                this.priority = priority;
            }
            
            Node[] split(int key) {
                Node leftTree = null;
                Node rightTree = null;
                Node[] splittedTrees;
                if (value <= key) {
                    leftTree = this;
                    if (right != null) {
                        splittedTrees = right.split(key);
                        leftTree.right = splittedTrees[0];
                        rightTree = splittedTrees[1];
                    }
                } else {
                    rightTree = this;
                    if (left != null) {
                        splittedTrees = left.split(key);
                        leftTree = splittedTrees[0];
                        rightTree.left = splittedTrees[1];
                    }
                }
                return new Node[] {leftTree, rightTree};
            }
            
            void add(Node parent, Node node) {
                if (priority < node.priority) {
                    Node[] subNodes = this.split(node.value);
                    node.left = subNodes[0];
                    node.right = subNodes[1];
                    if (parent != null) {
                        if (this == parent.left) {
                            parent.left = node;
                        } else {
                            parent.right = node;
                        }
                    } else {
                        treapRoot = node;
                    }
                } else {
                    if (value < node.value) {
                        if (right != null) {
                            right.add(this, node);
                        } else {
                            right = node;
                        }
                    } else {
                        if (left != null) {
                            left.add(this, node);
                        } else {
                            left = node;
                        }
                    }
                }
            }
            
            @Override
            public String toString() {
                return "[" + value + ";" + priority + "]"; 
            }
            
            private void traverseInOrder() {
                ++currentHeight;
                if (currentHeight > maximumHeight) {
                    maximumHeight = currentHeight;
                }
                if (left != null) {
                    left.traverseInOrder();
                }
                if (right != null) {
                    right.traverseInOrder();
                }
                --currentHeight;
            }
        } // end of class Node
        
        private Node treapRoot;
        private int maximumHeight;
        private int currentHeight;
        
        void add(int value, int priority) {
            Node node = new Node(value, priority);
            if (treapRoot != null) {
                treapRoot.add(null, node);
            } else {
                treapRoot = node;
            }
        }
        
        int getHeight() {
            if (treapRoot != null) {
                treapRoot.traverseInOrder();
                return maximumHeight;
            } else {
                return 0;
            }
        }
    } // end of static class Treap

    private static class NaiveBinaryTree {
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

            @Override
            public String toString() {
                return Integer.toString(value);
            }
        
            private void traverseInOrder() {
                level++;
                if (level > maximumHeight) {
                    maximumHeight = level;
                }
                if (left != null) {
                    left.traverseInOrder();
                }
                if (right != null) {
                    right.traverseInOrder();
                }
                level--;
            }
        }

        private TreeNode root;
        
        private int maximumHeight;
        private int level;

        void add(int value) {
            if (root != null) {
                root.add(value);
            } else {
                root = new TreeNode(value);
            }
        }
        
        int getHeight() {
            if (root != null) {
                root.traverseInOrder();
                return maximumHeight;
            } else {
                return 0;
            }
        }
    } // end of static class NaiveBinaryTree

}
