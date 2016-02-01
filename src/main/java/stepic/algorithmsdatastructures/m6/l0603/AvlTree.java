package stepic.algorithmsdatastructures.m6.l0603;

public class AvlTree {
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
//            if (wasBalanced) {
                wasBalanced = balance();
//            }
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
        
        private void toStringBuilderInOrder(StringBuilder sb) {
            if (left != null) {
                left.toStringBuilderInOrder(sb);
            }
            sb.append(toString());
            sb.append(' ');
            if (right != null) {
                right.toStringBuilderInOrder(sb);
            }
        }
        
        private void toStringBuilderPostOrder(StringBuilder sb) {
            if (left != null) {
                left.toStringBuilderPostOrder(sb);
            }
            if (right != null) {
                right.toStringBuilderPostOrder(sb);
            }
            sb.append(toString());
            sb.append(' ');
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
    
    void addLeft(int value) {     // For testing purposes
        if (treeRoot == null) {
            treeRoot = new Node(value, null);
        } else {
            treeRoot.addLeft(value);
        }
    }
    
    void addRight(int value) {     // For testing purposes
        if (treeRoot == null) {
            treeRoot = new Node(value, null);
        } else {
            treeRoot.addRight(value);
        }
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
    
    String toStringPostOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (treeRoot != null) {
            treeRoot.toStringBuilderPostOrder(sb);
        }
        sb.append("]");
        return sb.toString();
    }
    
    String toStringInOrder() {
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
