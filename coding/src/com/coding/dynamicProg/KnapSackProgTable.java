package com.coding.dynamicProg;

import java.util.ArrayList;
import java.util.List;

public class KnapSackProgTable {
    public static void main(String[] args) {

        int weight[] = {2, 1, 5, 3};
        int value [] = {300, 200, 400, 500};
        int capacity = 10;


        int [][] arrayTable = new int[value.length+1][capacity+1];

        for(int i=1;i<=value.length;i++){
            for(int j=1;j<=capacity;j++){
                if(weight[i-1]<=j){
                    System.out.println("values at : "+i+": "+ value[i-1] + " getting the array table value: "
                    +arrayTable[i-1][j-weight[i-1]]);
                    System.out.println("getting the val at j: "+j+" and val at j "+j+"-"+" weight "+i);
                    System.out.println("value at: "+arrayTable[i-1][j-weight[i-1]]);
                    int includeItem = value[i-1] + arrayTable[i-1][j-weight[i-1]];
                    int excludeItem = arrayTable[i-1][j];
                    arrayTable[i][j] = Math.max(includeItem,excludeItem);
                }
                else{
                    arrayTable[i][j] = arrayTable[i-1][j];
                }
            }
        }
        System.out.println(arrayTable[value.length][capacity]);

        List<Integer> itemsIncluded = new ArrayList<>();
        int w = capacity;
        for (int i = value.length; i > 0; i--) {
            System.out.println(arrayTable[i][w]+"---"+arrayTable[i - 1][w]);
            if (arrayTable[i][w] != arrayTable[i - 1][w]) {
                itemsIncluded.add(i - 1);
                w -= weight[i - 1];
            }
        }

        System.out.println("\nItems included: " + itemsIncluded);


    }

    private static int knapSackProblem(int[] weight, int[] value, int capacity, int length) {

        if(length ==0 || capacity ==0){
            return 0;
        }
        if(weight[length-1]>capacity){
            return knapSackProblem(weight,value,capacity,length-1);
        }
        else{
            int includeItem= value[length - 1] +knapSackProblem(weight, value, capacity - weight[length - 1], length - 1);
             int excludeItem=knapSackProblem(weight, value, capacity, length - 1);
            return Math.max(includeItem,excludeItem);
        }
    }
}
