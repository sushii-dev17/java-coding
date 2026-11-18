package com.tree;

public class AvlTree {

    public static class Node {

        int val;
        Node left;
        Node right;
        int height;

        Node(int val) {
            this.val = val;
        }

        private int getValue() {
            return val;
        }
    }

    private Node root;

    public AvlTree() {
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.val) {
            node.left = insert(node.left, value);
            System.out.println("adding " + node.left.val + " in left of :" + node.val);
        }

        if (value > node.val) {
            node.right = insert(node.right, value);
            System.out.println("adding " + node.right.val + " in right of :" + node.val);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public Node rotate(Node node){

        if(height(node.left) - height(node.right)>1){
            //left heavy
            if(height(node.left.left) - height(node.left.right)>0){
                //left left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right)<0){
                //left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right)<-1){
            //left heavy
            if(height(node.right.left) - height(node.right.right)<0){
                //right right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right)>0){
                //right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node parent){
        Node child = parent.left;
        Node t2 = child.right;

        child.right =parent;
        parent.left =t2;

        return child;
    }

    public Node leftRotate(Node child){
        Node parent = child.right;
        Node t2 = parent.left;

        parent.left =child ;
        child.right = t2;

        return parent;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    public boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void display() {
        System.out.println();
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String s) {
        if (node == null) {
            return;
        }
        System.out.println(s + node.val);
        display(node.left, "left child of " + node.val + " : ");
        display(node.right, "right child of " + node.val + " : ");
    }

    public void displayPreOrder() {
        System.out.println();
        displayPreOrder(this.root);
    }

    private void displayPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val+" ");
        displayPreOrder(node.left);
        displayPreOrder(node.right);
    }


    public void displayPostOrder() {
        System.out.println();
        displayPostOrder(this.root);
    }

    private void displayPostOrder(Node node) {
        if (node == null) {
            return;
        }
        displayPreOrder(node.left);
        displayPreOrder(node.right);
        System.out.println(node.val+" ");
    }
}
