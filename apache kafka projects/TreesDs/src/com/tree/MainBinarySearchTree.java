package com.tree;

import java.util.Collections;
import java.util.List;

public class MainBinarySearchTree {

    public static void main(String[] args) {


        BinarySearchTree bst = new BinarySearchTree();

        bst.populate(new int[] {5,2,7,1,4,6,9,8,10});
        //bst.populate(new int[] {1,2,3,4,5,6,7,8,9,10,11});
        bst.display();
        //bst.displayByLevel();
        System.out.println();
       /* List<List<Integer>> lists = bst.levelOrder();
        System.out.println(lists);*/

        /*List<Double> doubles = bst.levelOrderFindAvg();
        System.out.println(doubles);*/

    /*    BinarySearchTree.Node successor = bst.findSuccessor(8);
        System.out.println(successor.val);
*/
       /* List<List<Integer>> lists = bst.levelOrderPrintZigZag();
        System.out.println(lists);*/

        List<List<Integer>> lists1 = bst.levelOrderBottom();

        System.out.println(lists1);

        Collections.reverse(lists1);

        System.out.println(lists1);

        System.out.println(bst.isBalanced());
    }


}
