package stepic.algorithmsdatastructures.m6.l0603;

public class AvlTree {
    private class Node {
        private int value;
        private Node parent;
        private Node left;
        private Node right;
        
        private Node(int value, Node parent) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return Integer.toString(value);
        }
        
        public void toStringBuilderInOrder(StringBuilder sb) {
            if (left != null) {
                left.toStringBuilderInOrder(sb);
            }
            sb.append(toString());
            sb.append(' ');
            if (right != null) {
                right.toStringBuilderInOrder(sb);
            }
        }
        
        public void toStringBuilderPostOrder(StringBuilder sb) {
            if (left != null) {
                left.toStringBuilderPostOrder(sb);
            }
            if (right != null) {
                right.toStringBuilderPostOrder(sb);
            }
            sb.append(toString());
            sb.append(' ');
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
            if (parent != null) {
                if (parent.left == this) {
                    parent.left = nodeRight;
                } else {
                    parent.right = nodeRight;
                }
            } else {
                treeRoot = nodeRight;
            }
            parent = nodeRight;
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
            if (parent != null) {
                if (parent.right == this) {
                    parent.right = nodeLeft;
                } else {
                    parent.left = nodeLeft;
                }
            } else {
                treeRoot = nodeLeft;
            }
            parent = nodeLeft;
        }
       
        public void add(int value) {
            if (this.value < value) {
                if (right != null) {
                    right.add(value);
                } else {
                    right = new Node(value, this);
                }
                // balance
            } else {
                if (left != null) {
                    left.add(value);
                } else {
                    left = new Node(value, this);
                }
            }
            balance();
        }

        private boolean balance() {
            int diff = compareHeights(left, right);
            if (diff > 1) {
                // TODO right rotation
                
                return true;
            } else if (diff < -1) {
                // TODO left rotation
                
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
        
        Node addLeft(int value) {   // For testing purposes
            if (left == null) {
                left = new Node(value, this);
                return left;
            } else {
                return left.addLeft(value);
            }
        }
        
        Node addRight(int value) {  // For testing purposes
            if (right == null) {
                right = new Node(value, this);
                return right;
            } else {
                return right.addRight(value);
            }
        }
    } // end of private class Node
    
    private Node treeRoot;
    
    void buildBalancedManuallyForTest() {      // For testing purposes
        treeRoot = new Node(55, null);
        Node leftNode = treeRoot.addLeft(33);
        leftNode.addLeft(22);
        leftNode.addRight(44);
        Node rightNode = treeRoot.addRight(88);
        rightNode.addLeft(77);
        rightNode.addRight(99);
    }
    
    void rotateLeftShort() {    // For testing purposes
        if (treeRoot != null) {
            treeRoot.rotateLeftShort();
        }
    }
    
    void rotateRightShort() {    // For testing purposes
        if (treeRoot != null) {
            treeRoot.rotateRightShort();
        }
    }
    
    public void add(int value) {
        if (treeRoot == null) {
            treeRoot = new Node(value, null);
        } else {
            // TODO add
        }
    }
    
    public int getHeight() {
        if (treeRoot != null) {
            return treeRoot.getHeight();
        }
        return 0;
    }
    
    
    public void addLeft(int value) {     // For testing purposes
        if (treeRoot == null) {
            treeRoot = new Node(value, null);
        } else {
            treeRoot.addLeft(value);
        }
    }
    
    public void addRight(int value) {     // For testing purposes
        if (treeRoot == null) {
            treeRoot = new Node(value, null);
        } else {
            treeRoot.addRight(value);
        }
    }
    
    public String toStringPostOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (treeRoot != null) {
            treeRoot.toStringBuilderPostOrder(sb);
        }
        sb.append("]");
        return sb.toString();
    }
    
    public String toStringInOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (treeRoot != null) {
            treeRoot.toStringBuilderInOrder(sb);
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        AvlTree t = new AvlTree();
        System.out.println(t.toStringInOrder());
    }
}
