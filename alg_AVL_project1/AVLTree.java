/**
 * Olivia Nye
 * 
 * AVL Tree
 * 
 * Intro to Algorithms Project 1 - Milestone 1
 * 
 * This class implements an AVL Tree. 
 * 
 *  */

package alg_AVL_project1;


public class AVLTree<E extends Comparable<? super E>> {
    protected Node root;
    protected int size;

    /**
     * Construct an empty AVLTree.
     */
    public AVLTree() {
        // not necessary, but explicit stating root starts at null
        this.root = null;
        this.size = 0; //size is the total # of nodes in the tree
    }

    /**
     * Insert the element into this AVLTree.
     *
     * @param element the element to insert into the tree. Duplicates are
     *                allowed
     */
    public void insert(E element) {
        this.root = insert(this.root, element);
        this.size++;
    }

    /**
     * Remove the element from this AVLTree.
     *
     * @param element the element to remove
     */
    public void remove(E element) {
        this.root = remove(this.root, element);
        this.size--;
    }

    /**
     * Checks if this tree contains the element.
     *
     * @return true if this tree contains the element, false otherwise
     */
    public boolean contains(E element) {
        return contains(this.root, element);
    }

    /**
     * Return the minimum elemnent in this tree.
     *
     * @return the mininum element in this tree
     */
    public E findMin() {
        return findMin(this.root);
    }

    /**
     * A protected helper method for insertion.
     * By taking a Node as a parameter, we can write this method
     * recursively, continuing to call insert on subtrees until the element
     * can be inserted.
     * @param node the root of some subtree of this AVLTree
     * @param element the element to insert into this subtree
     * @return root node of tree, after insertion of the element
     */
    protected Node insert(Node node, E element) {

    	if(node == null) {
            return new Node(element);
        }
        // if element is less than the value contained by node...
        if(element.compareTo(node.element) < 0) {
            // insert element into the left subtree
            node.left = insert(node.left, element);
        } else {
            // insert element into the right subtree
            node.right = insert(node.right, element);
        }
        if(Math.abs(height(node.left) - height(node.right)) > 1) {
            node = balance(node, element);
        }
        // update this node's height using the protected helper method
        // height().
        node.height = this.height(node);
        return node;
    }


    /**
     * A protected helper method for removal.
     * By taking a Node as a parameter, we can write this method
     * recursively, continuing to call remove on subtrees until the element
     * is removed.
     * @param node the root of some subtree of this AVLTree
     * @param element the element to remove from this subtree
     * @return root node of tree, after removal of the element
     */
    protected Node remove(Node node, E element) {
        if (node == null) {
            //tree is empty. return node. same as returning null
            return node;
        }
        if (node.element.compareTo(element) > 0) {
            node.left = remove(node.left, element);
        } else if (node.element.compareTo(element) < 0) {
            node.right = remove(node.right, element);
        } else {
            //if you reached a leaf null but was not able to find the element we're trying to remove. Tree has exhausted
            if (node.left == null && node.right == null) {
                return node;
            }
            if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.right == null && node.left != null) {
                return node.left;
            } else {
                E temp = findMin(node.right);
                node.element = temp;
                node.right = remove(node.right, temp);
            }
        }
        node.height = this.height(node);
        node = balance(node, element);
        return node;
    }
    

    /**
     * As for insert and remove, a protected helper is used for a recursive
     * implementation.
     * @param element the element to search for
     * @param node the root of the subtree to search in
     * @return true if this subtree contains the element, false otherwise
     */
    protected boolean contains(Node node, E element) {
        if (node == null) {
            return false;
        }
        if (element.compareTo(node.element) == 0) {
            return true;
        }
        if (element.compareTo(node.element) < 0) {
            return contains(node.left, element);
        } else {
            return contains(node.right, element);
        }
    }

    /**
     * Return the minimum element in the subtree rooted at node
     * @param node the root of the subtree
     * @return the minimum element in this subtree
     */
    protected E findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }
    /**
     * Obtain the difference between the heights of a node's left and right subtrees 
     * @param node the root of the subtree to analyze the balance of
     * @return the difference in heights
     */
    protected int getBalance(Node node) {
        if (node.element == null) {
            return -1;
        } else {
            return height(node.left) - height(node.right);
        }
    }

    /**
     * Balance the subtree rooted at this node.
     * @param node the root of the subtree to balance
     * @param element that is suspected to have caused an imbalance
     * @return the new root node of the balanced subtree
     */
    protected Node balance(Node node, E element) {
        if (node == null){
          return node;
        }  
        int balance = height(node.left) - height(node.right);
        
        if(balance > 1 && (int)element < (int)node.left.element){
          return singleRotateWithLeftChild(node); 
        }

        if (balance < -1 && (int)element > (int)node.right.element){
        	return singleRotateWithRightChild(node);
        }


        if (balance > 1 && (int)element>(int)node.left.element){
            return doubleRotateWithLeftChild(node);
        }

        if (balance < -1 && (int)element<(int)node.right.element){
          return doubleRotateWithRightChild(node);
        }
        return null;//THIS SHOULD PROB BE RETURNING NODE. 

      }

    /**
     * Perform a single rotation for left outside case.
     * @param node the root of the subtree to rotate
     * @return the new root of this subtree
     */
    protected Node singleRotateWithLeftChild(Node node) {

        //original left subtree of root becomes root of new tree
        Node newNode = node.left;
        node.left = node.left.right;
        newNode.right = node;
        return newNode; 
    }


    /**
     * Perform a single rotation for right outside case.
     * @param node the root of the subtree to rotate
     * @return the new root of this subtree
     */
    protected Node singleRotateWithRightChild(Node node) {
        Node newNode = node.right;
        node.right = node.right.left;
        newNode.left = node;
        return newNode;
    }

    /**
     * Perform a double rotation for left inside case.
     * @param node the root of the subtree to rotate
     * @return the new root of this subtree
     */
    protected Node doubleRotateWithLeftChild(Node node) {
        Node newNode = node;
        newNode.left = singleRotateWithRightChild(node.left);
        
        newNode = singleRotateWithLeftChild(newNode);
        return newNode;
    }

    /**
     * Perform a double rotation for right inside case.
     * @param node the root of the subtree to rotate
     * @return the new root of this subtree
     */
    protected Node doubleRotateWithRightChild(Node node) {
        Node newNode = node;
        newNode.right = singleRotateWithLeftChild(node.right);
        newNode = singleRotateWithRightChild(newNode);
        return newNode;
    }

    /**
     * protected helper method to calculate the height of a node. A node's
     * height is the larger of its left and right subtree's heights plus
     * one. To make this calculation consistent and easy, we define
     * height of an empty subtree is -1.
     * @param node the node to calculate the height of
     * @return its height as determined by the heights of its subtrees
     */
    protected int height(Node node) {
        if (node == null) {
            return -1;
        }
        // if the left child is null, its height is -1, otherwise, retrieve
        // its height
        int leftHeight = (node.left == null ? -1 : node.left.height);
        // same
        int rightHeight = (node.right == null ? -1 : node.right.height);
        return Math.max(leftHeight, rightHeight) + 1;

    }

    public class Node {
        // since this is a protected inner class, and the outer AVLTree class
        // will need to freely modify the connections and update the height
        // of its nodes, the following three variables are not protected.
        Node left;
        Node right;
        int height;
        E element;

        /**
         * Construct an AVLTreeNode. At instantiation, each node has no
         * children and therefore a height of 0.
         * @param element the element that this node contains
         */
        public Node(E element) {
            this.left = null;
            this.right = null;
            this.height = 0;
            this.element = element;
        }
    }
}

