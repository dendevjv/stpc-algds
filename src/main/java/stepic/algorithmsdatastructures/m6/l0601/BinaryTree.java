package stepic.algorithmsdatastructures.m6.l0601;

class BinaryTree {
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
}
