package com.tree;

import java.util.Scanner;

public class BinaryTree {

    public static class Node {

        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node");
        int value = scanner.nextInt();
        root = new Node(value);
        populateData(root, scanner);
    }

    public void populateData(Node node, Scanner scanner) {
        System.out.println("do you want to enter on the left of:" + node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("please enter the value on the left of:" + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populateData(node.left, scanner);
        }
        System.out.println("do you want to enter on the right15 of:" + node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("please enter the value on the right of:" + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populateData(node.right, scanner);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String s) {
        if (node == null) {
            return;
        }
        System.out.println(s + node.val);
        display(node.left, s + "\t");
        display(node.right, s + "\t");
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
