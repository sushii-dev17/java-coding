package com.coding.dynamicProg;

public class MinSubSetDiff2 {

    public static void main(String[] args) {

        int []arr = {1,2,7};
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
        }
        int n = arr.length;
        boolean[][] dp = equalSum(arr, sum, n);
        int [] vector = new int[sum/2+1];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<vector.length;i++){
            if(dp[n][i]){
                vector[i] = i;
                min=Math.min(min,sum-2*vector[i]);
            }
        }
        System.out.println(min);
    }

    private static boolean[][] equalSum(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            dp[i][0] = true;
            for(int j=1;j<=sum;j++){
                dp[0][j] =false;
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp;
    }

}
