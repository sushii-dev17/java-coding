package com.tree;

import java.util.Scanner;

public class MainBinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        Scanner s = new Scanner(System.in);
        binaryTree.populate(s);
        binaryTree.preetydisplay();

    }
}
