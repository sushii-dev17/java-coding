package com.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {

    HashMap<Character,String> encode;
    HashMap<String,Character> decoder;

    private class Node implements Comparable<Node>{

        Character data;
        int cost;// frquesncy;
        Node left;
        Node right;

        public Node(Character data,int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right=null;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost-node.cost;
        }
    }

    public  HuffmanCoder(String feeder) throws Exception{
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(int i=0;i<feeder.length();i++){

               fmap.put(feeder.charAt(i), fmap.getOrDefault(feeder.charAt(i),0)+1);

        }
        System.out.println(fmap);


        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character,Integer>> entrySet = fmap.entrySet();

        for(Map.Entry<Character,Integer> entry: entrySet){
            Node node = new Node(entry.getKey(),entry.getValue());
            minHeap.insert(node);
        }

        while(minHeap.size()!=1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0',first.cost+second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        Node fullTree = minHeap.remove();

        this.encode = new HashMap<>();
        this.decoder = new HashMap<>();
        this.initEncoderDecoder(fullTree,"");
    }

    private void initEncoderDecoder(Node node, String outputSoFar) {
        if(node == null){
            return;
        }

        if (node.left == null && node.right == null) {
            this.encode.put(node.data,outputSoFar);
            this.decoder.put(outputSoFar,node.data);
        }
        initEncoderDecoder(node.left,outputSoFar+"0");
        initEncoderDecoder(node.right,outputSoFar+"1");
    }

    public String encode(String source){

        String ans = "";
        for(int i=0;i<source.length();i++){
            ans = ans + encode.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codedString){
        String key = "";
        String ans="";
        for(int i=0;i<codedString.length();i++){
            key = key +codedString.charAt(i);

            if(decoder.containsKey(key)){
                ans = ans + decoder.get(key);
                key ="";
            }
        }
        return ans;

    }
}
