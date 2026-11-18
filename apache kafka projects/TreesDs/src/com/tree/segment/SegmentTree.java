package com.tree.segment;

public class SegmentTree {

    public static void main(String[] args) {
        int [] arr = {3,8,6,7,-2,-8,4,9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
        int query = segmentTree.query(1, 6);
        System.out.println(query);
        int update = segmentTree.update(0, 1);
        System.out.println(update);

    }
    public static class Node {

        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(){

        }
        public Node(int data){
            this.data = data;
        }
        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }
    private Node root;
    public SegmentTree(int [] arr) {
        this.root = constructTree(arr,0, arr.length-1);
    }


    public Node constructTree(int []arr,int start,int end){
        if(start == end){
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        //create new node with index i am at
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);

        node.data = node.left.data+node.right.data;
        return node;
    }

    public void display(){
        display(this.root);
    }
    public void display(Node node){
        String str = "";
        if(node.left != null){
            str= str+ "Interval=[" +node.left.startInterval+"-"+node.left.endInterval+"] and data: "+node.left.data+"=> ";
        }else{
            str= str+ "no left child left";
        }
        str= str+ "Interval=[" +node.startInterval+"-"+node.endInterval+"] and data: "+node.data+"=> " ;

        if(node.right != null){
            str= str+ "Interval=[" +node.right.startInterval+"-"+node.right.endInterval+"] and data: "+node.right.data+"=> ";
        }else{
            str= str+ "no right child left";
        }

        System.out.println(str +"\n");
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }

    public int query(int start,int end){
        return query(root,start,end);
    }
    public int query(Node node,int start,int end){

        if(node.startInterval>=start && node.endInterval<=end){
            return node.data;
        }
        if(node.startInterval>end || node.endInterval<start){
            return 0;
        }
            return this.query(node.left,start,end)+this.query(node.right,start,end);
    }

    public int update(int index,int value){
        return update(this.root,index,value);
    }
    public int update(Node node,int index,int value){

        if(index>=node.startInterval && index<=node.endInterval){
            //lies in this range
            if(index== node.startInterval && index == node.endInterval){
                node.data = value;
                return  node.data;
            }else{
                int leftAns = update(node.left,index,value);
                int rightAns = update(node.right,index,value);
                node.data = leftAns+rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}

