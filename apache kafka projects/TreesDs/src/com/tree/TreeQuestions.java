package com.tree;

import java.util.*;

public class TreeQuestions {

    int diameter = 0;
    int count =0;

    int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeQuestions treeQuestions = new TreeQuestions();
       // treeQuestions.populate(new int[]{4,2,7,1,3,6,9});
       //treeQuestions.populate(new int[]{1,2,3,4,5,6});
       treeQuestions.populate(new int[]{5,3,6,2,4,1});
        //treeQuestions.display();
        System.out.println("connect nodes..");
        //treeQuestions.connectNodes();
        //treeQuestions.display();
       // System.out.println(treeQuestions.isCousins(1, 6));
        //treeQuestions.findNode(7);

       // System.out.println(treeQuestions.diameterOfBinaryTree());

        //treeQuestions.invertTree();
        //treeQuestions.display();
        //  System.out.println(treeQuestions.maxDepthBTree());

       // treeQuestions.sortedArraytoBst(new int[]{-10, -3, 0, 5, 9});
        treeQuestions.display();
      // treeQuestions.flatten();
      /*  System.out.println(treeQuestions.isValidBinaryTree());
        Node node = treeQuestions.lowestCommonAncestor();
        System.out.println(node.val);*/
       // System.out.println(treeQuestions.kthSmallestElement(3));

        Node node = treeQuestions.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
       treeQuestions.display(node, "Root Node: ");
//        List<String> serialize = treeQuestions.serialize();
//        System.out.println(serialize);
//        treeQuestions.deserialize(serialize);
//        treeQuestions.display();

//        System.out.println(treeQuestions.hasPathSum(12));
//        System.out.println(treeQuestions.sumNumbers());

       // System.out.println(treeQuestions.maxPathSum());
       // System.out.println(treeQuestions.findPath(new int[]{5,3,4}));

    }

    public static class Node {

        int val;
        Node left;
        Node right;
        int height;

        Node next;

        Node(int val) {
            this.val = val;
        }

        private int getValue() {
            return val;
        }
    }

    private Node root;

    public TreeQuestions() {
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

    private void display(Node node, String s) {

        if (node == null) {
            return;
        }
        System.out.println(s + node.val);
        display(node.left, "left child of " + node.val + " : ");
        display(node.right, "right child of " + node.val + " : ");
    }

    public void connectNodes() {
        connectNodes(this.root);
    }

    private Node connectNodes(Node root) {

        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public void findNode(int x) {
        Node node = findNode(this.root, x);
        System.out.println(node.val + "->" + node.left.val + "->" + node.right.val);
    }

    public boolean isCousins(int x, int y) {
        return isCousins(this.root, x, y);
    }

    public boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return (
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSiblings(root, xx, yy))
        );
    }


    int level(Node node, Node x, int lev) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return lev;
        }

        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }

        return level(node.right, x, lev + 1);
    }

    private Node findNode(Node node, int x) {
        System.out.println();
        System.out.println("get the current node:" + node);
        if (node == null) {
            System.out.println("if null return node is :" + node);
            //or return node
            return null;
        }
        if (node.val == x) {
            return node;
        }
        System.out.println("check the lefy node now");
        Node leftSearch = findNode(node.left, x);
        System.out.println("leftSearch: " + leftSearch);
        //System.out.println("print leftSearch value =" +leftSearch.val+"->"+leftSearch.left.val+"->"+leftSearch.right.val);
        if (leftSearch != null) {
            return leftSearch;
        }
        System.out.println("check the right node now :" + node);
        Node rightSearch = findNode(node.right, x);
        System.out.println("rightSearch: " + rightSearch);
        return rightSearch;
       /* if(node.right!=null){
            return findNode(node.right,x);
        }*/
        //return node;
    }

    public boolean isSiblings(Node node, Node x, Node y) {
        if (node == null) {
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSiblings(node.left, x, y) || isSiblings(node.right, x, y));
    }

    public boolean isSymmetric(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node.left);
        queue.add(node.right);

        while (!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left != null || right != null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public int diameterOfBinaryTree() {
        return diameterOfBinaryTree(this.root);
    }

    public int diameterOfBinaryTree(Node root) {
        height1(root);
        return diameter - 1;
    }

    public int height1(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public Node invertTree(){
        return invertTree(this.root);
    }

    public Node invertTree(Node root){
        if(root == null){
            return root;
        }
        Node left=invertTree(root.left);
        Node right=invertTree(root.right);

       root.left = right;
          root.right = left;
        //swap(left,right);
        return root;
    }

    public int maxDepthBTree(){
        int depth = maxDepthBTree(this.root);
        return depth;
    }

    public int maxDepthBTree(Node root){
        if(root == null){
            return 0;
        }
        int left = maxDepthBTree(root.left);
        int right = maxDepthBTree(root.right);

       int depth= Math.max(left,right)+1;
       return depth;
    }

    public Node sortedArraytoBst(int [] nums){
        if(nums.length == 0){
            return null;
        }
        this.root= sortedArraytoBst(nums, 0, nums.length, this.root);
        return root;
    }

    public Node sortedArraytoBst(int [] nums,int start,int end,Node root){
        int mid = (start+end)/2;
        if(start >= end){
            return root;
        }
        if(root == null){
            root = new Node(nums[mid]);
        }
//        if(root.val == nums[mid]){
//            return  root;
//        }
        if(root.val>nums[mid]){
            Node left = new Node(nums[mid]);
            root.left = left;
            root = left;
        }
        if(root.val<nums[mid]){
            Node right = new Node(nums[mid]);
            root.right = right;
            root = right;
        }
        sortedArraytoBst(nums,start,mid,root);
        sortedArraytoBst(nums,mid+1,end,root);
        return root;
    }
    public void flatten(){
       // flatten(this.root);
        Queue<Integer> queue = new LinkedList<>();
        flattenWorse(root,queue);
        System.out.println(queue);
    }

    public Node flattenWorse(Node root,Queue<Integer> queue){
        if(root == null){
            return root;
        }
        queue.add(root.val);
        flattenWorse(root.left,queue);
        flattenWorse(root.right,queue);
        return root;
    }
    public void flatten(Node root){
        Node current = root;
        while(current!=null){
            if(current.left!= null){
                Node temp = current.left;
                while (temp.right!=null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    public boolean isValidBinaryTree(){
        return isValidBinaryTree(this.root);
    }

    public boolean isValidBinaryTree(Node node) {
        return isValidBinaryTree(node, null, null);
    }

    public boolean isValidBinaryTree(Node node,Integer lower,Integer upper) {
       if(node == null){
           return true;
       }
       if(lower!= null && node.val <= lower){
           return false;
       }
       if(upper!= null && node.val>=upper){
           return false;
       }

        boolean validBinaryTree = isValidBinaryTree(node.left, lower, node.val);
        boolean validBinaryTree1 = isValidBinaryTree(node.right, node.val, upper);

        return validBinaryTree && validBinaryTree1;
    }

    public Node lowestCommonAncestor(){
        Node node = lowestCommonAncestor(this.root, new Node(2), new Node(7));
        return node;
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root == null){
            return null;
        }
        if(root ==p || root == q){
            return root;
        }
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);

        if(left!= null && right!=null){
            return root;
        }

        return left == null?right:left;
    }

    public int kthSmallestElement(int k){
        return kthSmallestElement(this.root,k).val;
    }
    public Node kthSmallestElement(Node node, int k){
        if(node == null){
            return null;
        }
        Node left = kthSmallestElement(node.left,k);
        if(left!= null){
            return left;
        }
        count++;
        if (count == k){
            return node;
        }
        return kthSmallestElement(node.right,k);
    }

    public Node buildTree(int []preorder,int []inorder){
        if(preorder.length ==0){
            return null;
        }
        int r = preorder[0];
        int index =0;
        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == r){
                index =i;
            }
        }
        Node node = new Node(r);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),
                Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),
                Arrays.copyOfRange(inorder,index+1,inorder.length));

        return node;
    }
    public List<String> serialize(){
        return serialize(this.root);
    }

    public List<String> serialize(Node node){
        List<String> list = new ArrayList<>();
        helper(node,list);
        return list;
    }
    public void helper(Node node,List<String>list){
        if(node == null){
            list.add(null);
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left,list);
        helper(node.right,list);

    }

    public Node deserialize(List<String> list){
        Collections.reverse(list);
        return helper2(list);
    }
    public Node helper2(List<String> list){

        String data = list.remove(list.size()-1);
        if(data == null){
            return null;
        }
        Node node = new Node(Integer.parseInt(data));
        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }

    public boolean hasPathSum(int targetSum){
       return hasPathSum(this.root,targetSum);
    }
    public boolean hasPathSum(Node root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.val == targetSum && root.left==null && root.right== null){
            return true;
        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
           boolean right =hasPathSum(root.right, targetSum - root.val);

           return left || right;
    }

    public int sumNumbers(){
        return sumNumbers(this.root,0);
    }

    public int sumNumbers(Node node,int sum){
        if(node == null){
            System.out.println("null value");
            return 0;
        }
        sum = sum *10+node.val;
        System.out.println("sum: "+sum);
        if(node.left==null && node.right==null){
            System.out.println("return sum :"+sum);
            return sum;
        }
        int left = sumNumbers(node.left, sum);
        System.out.println("left:::"+left);
        int right = sumNumbers(node.right, sum);
        System.out.println("right:::"+right);
        return left+right;
    }

    public int maxPathSum(){
        return maxPathSum(this.root);
    }
    public int maxPathSum(Node node){
        helperPathSum(this.root);
        return ans;
    }

    public int helperPathSum(Node node){
        if(node == null){
            return 0;
        }
        int left = helperPathSum(node.left);
        int right =helperPathSum(node.right);

        left = Math.max(0,left);
        right = Math.max(0,right);

        int pathSum = left+right+node.val;

        ans = Math.max(ans,pathSum);

       return Math.max(left,right)+ node.val;

    }

    boolean findPath(int[] array){
        return findPath(this.root,array);
    }
    boolean findPath(Node node, int[] array){
        if(node == null){
            return array.length == 0;
        }
       return findPathHelper(node,array,0);
    }

    boolean findPathHelper(Node node, int [] array,int index){

        if(node == null){
            return false;
        }
        if(index>= array.length || node.val != array[index]){
            return false;
        }
        if(node.left==null && node.right==null && index == array.length -1){
            return true;
        }
        return findPathHelper(node.left,array,index+1)
                || findPathHelper(node.right,array,index+1);

    }

    int countPath(Node node,int sum){
        List<Integer> path = new LinkedList<>();
        return countPathHelper(node,sum,path);
    }
    int countPathHelper(Node node,int s,List<Integer> path){
        if(node ==null ){
            return 0;
        }
        path.add(node.val);

        int count =0;
        int pathSum =0;

        //hoe many path i can make
        ListIterator<Integer> itr = path.listIterator();
        while (itr.hasPrevious()){
            pathSum+=itr.previous();

            if(s==pathSum){
                count++;
            }
        }

        count+= countPathHelper(node.left,s,path) +countPathHelper(node.right,s,path);

        path.remove(path.size()-1);
        return count;

    }
}

