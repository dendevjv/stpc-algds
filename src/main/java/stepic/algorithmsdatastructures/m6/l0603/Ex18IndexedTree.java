/*
    В одной военной части решили построить в одну шеренгу по росту. 
    Т.к. часть была далеко не образцовая, то солдаты часто приходили не вовремя,
    а то их и вовсе приходилось выгонять из шеренги за плохо начищенные сапоги. 
    Однако солдаты в процессе прихода и ухода должны были всегда быть выстроены 
    по росту – сначала самые высокие, а в конце – самые низкие. 
    За расстановку солдат отвечал прапорщик, который заметил интересную 
    особенность – все солдаты в части разного роста. Ваша задача состоит в том, 
    чтобы помочь прапорщику правильно расставлять солдат, а именно для каждого 
    приходящего солдата указывать, перед каким солдатом в строе он должен становится. 
    Требуемая скорость выполнения команды - O(log n).
    
    Формат входных данных.
    Первая строка содержит число N – количество команд (1 ≤ N ≤ 30 000). 
    В каждой следующей строке содержится описание команды: 
    число 1 и X если солдат приходит в строй (X – рост солдата, 
    натуральное число до 100 000 включительно) и число 2 и Y если солдата, 
    стоящим в строе на месте Y надо удалить из строя. 
    Солдаты в строе нумеруются с нуля.
    
    Формат выходных данных.
    На каждую команду 1 (добавление в строй) вы должны выводить 
    число K – номер позиции, на которую должен встать этот солдат 
    (все стоящие за ним двигаются назад).
    
    Sample Input:
        5
        1 100
        1 200
        1 50
        2 1
        1 150
    Sample Output:
        0 0 2 1
 */
package stepic.algorithmsdatastructures.m6.l0603;

public class Ex18IndexedTree {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        AvlTree tree = new AvlTree();
        
        int length = in.nextInt();
        length /= 2;
        for (int i = 0; i < length; i++) {
            int cmd = in.nextInt();
            int number = in.nextInt();
            int index;
            if (cmd == 1) {
                index = tree.add(number);
            } else if (cmd == 2) {
            }
        }
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

    static class AvlTree {
        private class Node {
            private int value;
            private Node parent;
            private int index;
            private Node left;
            private Node right;
            
            private Node(int value, Node parent, int index) {
                this.value = value;
                this.parent = parent;
                this.index = index;
            }
            
            @Override
            public String toString() {
                return Integer.toString(value);
            }
           
            public int add(int value) {
                int addedIndex;
                if (this.value > value) {
                    if (right != null) {
                        checkIndexOfRightChild();
                        addedIndex = right.add(value);
                    } else {
                        addedIndex = index + 1;
                        right = new Node(value, this, addedIndex);
                    }
                } else {
                    ++index;
                    if (left != null) {
                        addedIndex = left.add(value);
                    } else {
                        addedIndex = index - 1;
                        left = new Node(value, this, addedIndex);
                    }
                }
                balance();
                return addedIndex;
            }

            private void checkIndexOfRightChild() {
                if ((right.index - index) < 1) {
                    right.index = index + 1;
                }
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
                            Node rightMax = right.getMax();
                            rightMax.parent.left = rightMax.right;
                            if (rightMax.right != null) {
                                rightMax.right.parent = rightMax.parent;
                            }
                            substitute = rightMax;
                            substitute.right = right; 
                            right.parent = substitute;
                        }
                        substitute.parent = parent;
                        substitute.left = left; 
                        substitute.index = this.index;
                        left.parent = substitute;
                    } else if (left != null) {  // Left child
                        left.parent = parent;
                        substitute = left;
                    } else if (right != null) { // Right child
                        right.parent = parent;
                        substitute = right;
                        substitute.index = this.index;
                    } else {                    // No children
                        substitute = null;
                    }
                    
                    setToParentNewChild(substitute);
                    
                    /* Clean references */
                    parent = null;
                    left = null;
                    right = null;
                    
                    deleted = true;
                } else if (value > this.value && left != null) {
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
            
            public void deleteByIndex(int index) {
                if (index == this.index) {
                    delete(this.value);
                } else {
                    if (index < this.index && left != null) {
                        left.deleteByIndex(index);
                        this.index--;
                    } else if (right != null) {
                        right.deleteByIndex(index);
                    }
                }
            }
            
            private Node getMax() {
                if (left != null) {
                    return left.getMax();
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
            
            private void toStringBuilderInOrder(StringBuilder sb) { // For testing
                if (left != null) {
                    left.toStringBuilderInOrder(sb);
                }
                sb.append(toString());
                sb.append(' ');
                if (right != null) {
                    right.toStringBuilderInOrder(sb);
                }
            }
            
        } // end of private class Node
        
        private Node treeRoot;
        
        /**
         * Adds value and returns index of occupied position.
         */
        public int add(int value) {
            if (treeRoot == null) {
                treeRoot = new Node(value, null, 0);
                return 0;
            } else {
                return treeRoot.add(value);
            }
        }

        public void delete(int value) {
            if (treeRoot != null) {
                treeRoot.delete(value);
            }
        }
        
        public void deleteByIndex(int index) {
            if (treeRoot != null) {
                treeRoot.deleteByIndex(index);
            }
        }
        
        public int getHeight() {
            if (treeRoot != null) {
                return treeRoot.getHeight();
            }
            return 0;
        }
        
        String toStringInOrder() {  // For testing
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (treeRoot != null) {
                treeRoot.toStringBuilderInOrder(sb);
            }
            sb.append("]");
            return sb.toString();
        }
        
    } // end of static class AvlTree
}
