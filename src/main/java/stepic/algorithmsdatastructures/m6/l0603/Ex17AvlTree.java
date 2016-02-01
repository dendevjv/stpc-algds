/*
    Напишите АВЛ-дерево.
    Дана последовательность команд добавления или удаления натуральных чисел 
    в АВЛ-дерево. Команда добавления числа A задается положительным числом A, 
    команда удаления числа A задается отрицательным числом “-A”. 
    Требуется вывести высоту АВЛ-дерева после выполнения всех команд.
    Предполагается, что во входных данных нет ситуации, при которой добавляется 
    элемент А, уже присутствующий в дереве.
    Sample Input:
        2 4 6 -2
    Sample Output:
        2
 */
package stepic.algorithmsdatastructures.m6.l0603;

public class Ex17AvlTree {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        AvlTree tree = new AvlTree();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n >= 0) {
                tree.add(n);
            } else {
                tree.delete(-n);
            }
        }
        in.close();
        System.out.println(tree.getHeight());
    }

    private static class AvlTree {
        private class Node {
            private int value;
            private Node parent;
            private Node left;
            private Node right;
            
            private Node(int value, Node parent) {
                this.value = value;
                this.parent = parent;
            }
            
            @Override
            public String toString() {
                return Integer.toString(value);
            }
           
            public boolean add(int value) {
                boolean wasBalanced = false;
                if (this.value < value) {
                    if (right != null) {
                        wasBalanced = right.add(value);
                    } else {
                        right = new Node(value, this);
                    }
                } else {
                    if (left != null) {
                        wasBalanced = left.add(value);
                    } else {
                        left = new Node(value, this);
                    }
                }
                wasBalanced = balance();
                return wasBalanced;
            }
            
            public boolean delete(int value) {
                boolean deleted = false;
                Node parentForBalancing = parent;
                Node substitute = null;
                if (this.value == value) {
                    if (left != null && right != null) { // Both children
                        if (right.left == null) {
                            substitute = right;
                        } else {
                            Node rightMin = right.getMin();
                            rightMin.parent.left = rightMin.right;
                            if (rightMin.right != null) {
                                rightMin.right.parent = rightMin.parent;
                            }
                            substitute = rightMin;
                            substitute.right = right; 
                            right.parent = substitute;
                        }
                        substitute.parent = parent;
                        substitute.left = left; 
                        left.parent = substitute;
                    } else if (left != null) {  // Left child
                        left.parent = parent;
                        substitute = left;
                    } else if (right != null) { // Right child
                        right.parent = parent;
                        substitute = right;
                    } else {                    // No children
                        substitute = null;
                    }
                    setToParentNewChild(substitute);
                    
                    /* Clean references */
                    parent = null;
                    left = null;
                    right = null;
                    
                    deleted = true;
                } else if (value < this.value && left != null) {
                    deleted = left.delete(value);
                } else {
                    deleted = right.delete(value);
                }
                if (deleted) {
                    if (parentForBalancing != null) {
                        parentForBalancing.balance();
                    } else if (substitute != null) {
                        substitute.balance();
                    }
                }
                return deleted;
            }
            
            private Node getMin() {
                if (left != null) {
                    return left.getMin();
                } else {
                    return this;
                }
            }
            
            private void rotateLeftShort() {
                if (right == null) {
                    return;
                }
                Node nodeRight = right;
                
                right = nodeRight.left;
                if (right != null) {
                    right.parent = this;
                }
                
                nodeRight.left = this;
                setToParentNewChild(nodeRight);
                parent = nodeRight;
            }
            
            private void rotateLeftLong() {
                if (right == null) {
                    return;
                }
                right.rotateRightShort();
                rotateLeftShort();
            }
            
            private void rotateRightLong() {
                if (left == null) {
                    return;
                }
                left.rotateLeftShort();
                rotateRightShort();
            }
            
            private void rotateRightShort() {
                if (left == null) {
                    return;
                }
                Node nodeLeft = left;
                
                left = nodeLeft.right;
                if (left != null) {
                    left.parent = this;
                }
                
                nodeLeft.right = this;
                setToParentNewChild(nodeLeft);
                parent = nodeLeft;
            }
            
            private void setToParentNewChild(Node child) {
                if (parent != null) {
                    if (parent.left == this) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                } else {
                    treeRoot = child;
                }
                if (child != null) {
                    child.parent = parent;
                }
            }

            private boolean balance() {
                int diff = compareHeights(left, right);
                if (diff > 1) {
                    int leftDiff = compareHeights(left.left, left.right);
                    if (leftDiff < 0) {
                        rotateRightLong();
                    } else {
                        rotateRightShort();
                    }
                    return true;
                } else if (diff < -1) {
                    int rightDiff = compareHeights(right.left, right.right);
                    if (rightDiff > 0) {
                        rotateLeftLong();
                    } else {
                        rotateLeftShort();
                    }
                    return true;
                }
                return false;
            }
            
            private int getHeight() {
                int height = 1;
                int leftHeight = 0;
                if (left != null) {
                    leftHeight = left.getHeight();
                }
                int rightHeight = 0;
                if (right != null) {
                    rightHeight = right.getHeight();
                }
                height += (leftHeight < rightHeight) ? rightHeight : leftHeight;
                return height;
            }
            
            private int compareHeights(Node leftBranch, Node rightBranch) {
                int leftHeight = 0;
                if (leftBranch != null) {
                    leftHeight = leftBranch.getHeight();
                }
                int rightHeight = 0;
                if (rightBranch != null) {
                    rightHeight = rightBranch.getHeight();
                }
                return leftHeight - rightHeight;
            }
            
        } // end of private class Node
        
        private Node treeRoot;
        
        public void add(int value) {
            if (treeRoot == null) {
                treeRoot = new Node(value, null);
            } else {
                treeRoot.add(value);
            }
        }

        public void delete(int value) {
            if (treeRoot != null) {
                treeRoot.delete(value);
            }
        }
        
        public int getHeight() {
            if (treeRoot != null) {
                return treeRoot.getHeight();
            }
            return 0;
        }
        
    } // end of static class AvlTree
}
