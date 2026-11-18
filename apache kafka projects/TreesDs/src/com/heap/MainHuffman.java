package com.heap;

public class MainHuffman {

    public static void main(String[] args) throws Exception {

        String str = "abbccda";
        HuffmanCoder hf = new HuffmanCoder(str);
        String encode = hf.encode(str);
        System.out.println(encode);
        String decode = hf.decode(encode);
        System.out.println(decode);

    }
}
