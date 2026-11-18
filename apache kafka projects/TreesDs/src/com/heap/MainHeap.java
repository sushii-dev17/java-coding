package com.heap;

import java.util.ArrayList;

public class MainHeap {

    public static void main(String[] args) throws Exception {

        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(11);
        heap.insert(2);
        heap.insert(6);
        heap.insert(9);


        ArrayList he = heap.heapsort();
        System.out.println(he);
    }
}
