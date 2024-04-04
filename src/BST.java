import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        BSTNode current = root;
        return recursiveSearch(val, current);
    }

    /**
     * The recursive method that search calls
     *
     * @param val
     * @param current
     * @return
     */
    public boolean recursiveSearch(int val, BSTNode current) {
        // If the current node is val, return true
        if (val == current.getVal()) {
            return true;
        }
        // If the val is less than the current, returns the left node
        if (val < current.getVal()) {
            return recursiveSearch(current.getLeft().getVal(), current.getLeft());
        }
        // If the val is greater than the current, returns the right node
        if (val > current.getVal()) {
            return recursiveSearch(current.getRight().getVal(), current.getRight());
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Create ArrayList and sets current at the root
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        BSTNode current = root;
        recursiveInOrder(arr, current);
        return arr;
    }

    /**
     * Recursive inorder method
     *
     * @param arr
     * @param current
     */

    public void recursiveInOrder(ArrayList<BSTNode> arr, BSTNode current) {
        // Base case
        if (current == null) {
            return;
        }
        recursivePreOrder(arr, current.getLeft());
        arr.add(current);
        recursivePreOrder(arr, current.getRight());
        return;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // Create ArrayList and sets current at the root
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        BSTNode current = root;
        recursivePreOrder(arr, current);
        return arr;
    }

    /**
     * Recursive preorder method
     *
     * @param arr
     * @param current
     */

    public void recursivePreOrder(ArrayList<BSTNode> arr, BSTNode current) {
        // Base case
        if (current == null) {
            return;
        }
        arr.add(current);
        recursivePreOrder(arr, current.getLeft());
        recursivePreOrder(arr, current.getRight());
        return;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // Create ArrayList and sets current at the root
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        BSTNode current = root;
        recursivePostOrder(arr, current);
        return arr;
    }

    /**
     * Recursive postorder method
     *
     * @param arr
     * @param current
     */

    public void recursivePostOrder(ArrayList<BSTNode> arr, BSTNode current) {
        // Base case
        if (current == null) {
            return;
        }
        recursivePreOrder(arr, current.getLeft());
        recursivePreOrder(arr, current.getRight());
        arr.add(current);
        return;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        BSTNode current = new BSTNode(val);
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
