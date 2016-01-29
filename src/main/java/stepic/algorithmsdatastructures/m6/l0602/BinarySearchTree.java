package stepic.algorithmsdatastructures.m6.l0602;

import java.util.Iterator;

public class BinarySearchTree <T extends Comparable<T>> implements Iterable<T> {
    private class TreeNode {
        private T data;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(T value, TreeNode parent) {
            data = value;
            this.parent = parent;
        }
        
        private void add(T value) {
            if (data.compareTo(value) > 0) {
                if (left == null) {
                    left = new TreeNode(value, this);
                } else {
                    left.add(value);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(value, this);
                } else {
                    right.add(value);
                }
            }
        }
        
        // TODO Use copying data instead of changing node references (Lec.6.2.4)
        private boolean delete(T value) {
            boolean deleted = false;
            if (data.equals(value)) {
                TreeNode substitute = null;
                if (left != null && right != null) { // 1) Both children
                    if (right.left == null) {
                        substitute = right;
                    } else {
                        TreeNode rightMin = right.getMin();
                        rightMin.parent.left = rightMin.right; // Saving right of substitute
                        substitute = rightMin;
                        substitute.right = right; // Saving right of deleted
                    }
                    substitute.parent = parent;
                    substitute.left = left;
                } else if (left != null) {  // 2) Left child
                    left.parent = parent;
                    substitute = left;
                } else if (right != null) { // 3) Right child
                    right.parent = parent;
                    substitute = right;
                } else {
                    substitute = null;        // 4) No children
                }
                
                if (parent != null) {
                    if (parent.left == this) {
                        parent.left = substitute;
                    } else {
                        parent.right = substitute;
                    }
                } else {        // This is root
                    treeRoot = substitute;
                }
                /* Clean references */
                data = null;
                parent = null;
                left = null;
                right = null;
                
                deleted = true;
            } else if (data.compareTo(value) > 0 && left != null) {
                deleted = left.delete(value);
            } else if (right != null) {
                deleted = right.delete(value);
            }
            return deleted;
        }
        
        private TreeNode find(T value) {
            if (data.equals(value)) {
                return this;
            } else if (data.compareTo(value) > 0) {
                if (left != null) {
                    return left.find(value);
                } else {
                    return null;
                }
            } else {
                if (right != null) {
                    return right.find(value);
                } else {
                    return null;
                }
            }
        }
        
        private TreeNode getMin() {
            if (left != null) {
                return left.getMin();
            } else {
                return this;
            }
        }
        
        private TreeNode getMax() {
            if (right != null) {
                return right.getMax();
            } else {
                return this;
            }
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    
    private TreeNode treeRoot;

    public boolean contains(T value) {
        if (treeRoot != null) {
            TreeNode result = treeRoot.find(value);
            return result != null;
        } else {
            return false;
        }
    }
    
    public boolean delete(T value) {
        if (treeRoot == null) {
            return false;
        }
        return treeRoot.delete(value);
    }
    
    public T getMin() {
        if (treeRoot != null) {
            return treeRoot.getMin().data;
        }
        return null;
    }
    
    public T getMax() {
        if (treeRoot != null) {
            return treeRoot.getMax().data;
        }
        return null;
    }
    
    public void add(T value) {
        if (treeRoot != null) {
            treeRoot.add(value);
        } else {
            treeRoot = new TreeNode(value, null);
        }
    }

    @Override
    public Iterator<T> iterator() {
        TreeNode min = treeRoot.getMin();
        return new TreeNodeIterator(min);
    }
    
    private class TreeNodeIterator implements Iterator<T> {
        private TreeNode prev;
        private TreeNode node;
        
        private TreeNodeIterator(TreeNode startingNode) {
            node = startingNode;
            prev = null;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            TreeNode nn = nextNode(node, prev);
            
            T value = node.data;
            
            prev = node;
            node = nn;
            
            return value;
        }
        
        private TreeNode nextNode(TreeNode current, TreeNode previous) {
            TreeNode next = null;
            if (previous == null || previous == current.left) {
                next = (current.right == null) ? current.parent : current.right;
            } else if (previous == current.right) {
                next = current.parent;
            } else if (previous == current.parent) {
                if (current.left != null) {
                    next = current.left;
                } else if (current.right != null) {
                    next = current.right;
                } else {
                    
                    next = current.parent;
                }
            }
            return next;
        }
        
    }
}
