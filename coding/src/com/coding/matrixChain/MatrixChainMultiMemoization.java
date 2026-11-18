package com.coding.matrixChain;

import java.util.Arrays;

public class MatrixChainMultiMemoization {
    public static void main(String[] args) {

        int [] arr = {2, 1, 3, 4};

        int [][] dp = new int[arr.length+1][arr.length+1];

        for(int [] row:dp) {
            Arrays.fill(row, -1);
        }

        //find min cost
        int solve = solve(arr, 1, arr.length - 1,dp);

        System.out.println("solve : "+solve);
    }

    public static int solve(int [] arr, int i, int j,int [][]dp){
        System.out.printf("getting value of i: %d and j: %d:",i,j);
        System.out.println();
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1){
            System.out.println("inside meoization: "+ dp[i][j]);
            return dp[i][j];
        }

        int min =Integer.MAX_VALUE;
        System.out.println("min value :"+min);

        for(int k =i;k<=j-1;k++){

            int left = solve(arr, i, k,dp);
            System.out.println("left: "+left);
            int right = solve(arr,k+1,j,dp);
            System.out.println("right: "+right);
            int temp = left +
                   right+
                    arr[i-1]*arr[k]*arr[j];
            System.out.println("temp value :" +temp);

            if(temp<min){
                min = temp;
            }
        }
        dp[i][j] = min;
        return min;
    }
}
