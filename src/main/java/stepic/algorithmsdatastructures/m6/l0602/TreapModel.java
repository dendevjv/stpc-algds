package stepic.algorithmsdatastructures.m6.l0602;

public class TreapModel {
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
        
        private void toStringBuilder(StringBuilder sb) {
            sb.append('{');
            sb.append(value);
            sb.append(';');
            sb.append(priority);
            sb.append('}');
            sb.append(' ');
        }
        
        private void toStringBuilderInOrder(StringBuilder sb) {
            if (left != null) {
                left.toStringBuilderInOrder(sb);
            }
            toStringBuilder(sb);
            if (right != null) {
                right.toStringBuilderInOrder(sb);
            }
        }
        
        private void toStringBuilderPreOrder(StringBuilder sb) {
            toStringBuilder(sb);
            if (left != null) {
                left.toStringBuilderPreOrder(sb);
            }
            if (right != null) {
                right.toStringBuilderPreOrder(sb);
            }
        }
        
        private void traverseInOrder() {
            ++currentLevel;
            if (currentLevel > maximumHeight) {
                maximumHeight = currentLevel;
            }
            if (left != null) {
                left.traverseInOrder();
            }
            if (right != null) {
                right.traverseInOrder();
            }
            --currentLevel;
        }
    } // end of class Node
    
    private Node treapRoot;
    private int maximumHeight;
    private int currentLevel;
    
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
    
    static Node merge(Node leftNode, Node rightNode) {
        if (leftNode == null || rightNode == null) {
            return (leftNode == null) ? rightNode : leftNode;
        }
        if (leftNode.priority > rightNode.priority) {
            leftNode.right = merge(leftNode.right, rightNode);
            return leftNode;
        } else {
            rightNode.left = merge(leftNode, rightNode.left);
            return rightNode;
        }
    }
    
    TreapModel[] split(int key) {
        Node[] n1n2 = treapRoot.split(key);
        TreapModel t1 = new TreapModel();
        t1.treapRoot = n1n2[0];
        TreapModel t2 = new TreapModel();
        t2.treapRoot = n1n2[1];
        return new TreapModel[] {t1, t2};
    }
    
    public String toStringInOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (treapRoot != null) {
            treapRoot.toStringBuilderInOrder(sb);
        }
        sb.append("]");
        return sb.toString();
    }
    
    public String toStringPreOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (treapRoot != null) {
            treapRoot.toStringBuilderPreOrder(sb);
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        TreapModel treap = new TreapModel();
        treap.add(5, 14);
        treap.add(2, 11);
        treap.add(13, 12);
        treap.add(0, 6);
        treap.add(3, 8);
        treap.add(7, 9);
        treap.add(19, 10);
        treap.add(15, 7);
        treap.add(20, 5);
        treap.add(14, 2);
        treap.add(18, 3);
        treap.add(17, 0);
        
        System.out.println("In Order:");
        System.out.println(treap.toStringInOrder());
        System.out.println("Pre Order:");
        System.out.println(treap.toStringPreOrder());
    }
} // end of class TreapModel
