package com.coding.dynamicProg;

public class KnapSackProg {

   static int weight[] = {2, 1, 5, 3};
   static int value [] = {300, 200, 400, 500};
   static int capacity = 10;

    static Integer[][] dp = new Integer[value.length+1][capacity+1];
    public static void main(String[] args) {

        int maxProfit = knapSackProblemMemo(capacity, value.length);
        System.out.println(maxProfit);

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

    private static int knapSackProblemMemo(int capacity, int n) {

        System.out.println("knapsack_memoization(" + n + "," + capacity + ")");
        if(dp[n][capacity] !=null){
            System.out.println("Using memo for (" + n + "," + capacity + ")");
            return dp[n][capacity];
        }
        int result =0;
        if(n ==0 || capacity ==0){
            result= 0;
        }
       else if(weight[n-1]>capacity){
            result= knapSackProblemMemo(capacity,n-1);
        }
        else{
            int includeItem= value[n - 1] +knapSackProblemMemo(capacity - weight[n - 1], n - 1);
            int excludeItem=knapSackProblemMemo(capacity, n - 1);
            result = Math.max(includeItem,excludeItem);
        }
        dp[n][capacity]= result;
        return result;
    }
}
