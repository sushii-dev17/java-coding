package com.tree;

import java.util.*;

public class BinarySearchTree {

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

    public BinarySearchTree() {
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

    private void display(Node node,String s) {

        if (node == null) {
            return;
        }
        System.out.println(s + node.val);
        display(node.left, "left child of " + node.val + " : ");
        display(node.right, "right child of " + node.val + " : ");
    }

    public void displayByLevel() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        displayByLevel(queue);
    }

    private void displayByLevel(Queue<Node> queue) {

        if (!queue.isEmpty()) {
            Node currentNode = queue.peek();
            System.out.print(currentNode.val+" ");
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
            queue.poll();
            displayByLevel(queue);
        }
    }

    public List<List<Integer>> levelOrder() {
        List<List<Integer>> lists = levelOrder(this.root);
        return lists;
    }
    private List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> innerList = new ArrayList<>(level);
            for(int i=0;i<level;i++){
                Node currentNode = queue.poll();
                innerList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            result.add(innerList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom() {
        List<List<Integer>> lists = levelOrderBottom(this.root);
        return lists;
    }

    private List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> innerList = new ArrayList<>(level);
            for(int i=0;i<level;i++){
                Node currentNode = queue.poll();
                innerList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            result.add(0,innerList);

        }
        return result;
    }

    public List<List<Integer>> levelOrderPrintZigZag() {
        return levelOrderPrintZigZag(this.root);
    }


    private List<List<Integer>> levelOrderPrintZigZag(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        int actualLevel =0;
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> innerList = new ArrayList<>(level);
            Node currentNode = null;
            if(actualLevel %2!=0){
               // remove from back and add in first
                for(int i=0;i<level;i++){
                     currentNode = queue.removeLast();
                    innerList.add(currentNode.val);
                    if(currentNode.right!=null){
                        queue.addFirst(currentNode.right);
                    }
                    if(currentNode.left!=null){
                        queue.addFirst(currentNode.left);
                    }
                }
                result.add(innerList);
            }else{
                //remove from first add last
                for(int i=0;i<level;i++){
                    currentNode = queue.removeFirst();
                    innerList.add(currentNode.val);
                    if(currentNode.left!=null){
                        queue.addLast(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        queue.addLast(currentNode.right);
                    }
                }
                result.add(innerList);

            }
            actualLevel+=1;
        }
        return result;
    }

    public Node findSuccessor(int key) {
        return findSuccessor(this.root,key);
    }
    private Node findSuccessor(Node root,int key) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
                Node currentNode = queue.poll();
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                if(currentNode.val == key){
                    break;
                }
        }
        return queue.peek();
    }

    public List<Double> levelOrderFindAvg() {
        return levelOrderFindAvg(this.root);
    }
    private List<Double> levelOrderFindAvg(Node root) {

        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            double sum =0;
            for(int i=0;i<level;i++){
                Node currentNode = queue.poll();
                sum+=currentNode.val;
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            result.add(sum/level);
        }
        return result;
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

    public void preetydisplay() {
        preetydisplay(this.root, 0);
    }

    private void preetydisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        preetydisplay(node.right, level + 1);
        if (level != 0) {

            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----------->" + node.val);
        } else {
            System.out.println(node.val);
        }
        preetydisplay(node.left, level + 1);
    }
}
