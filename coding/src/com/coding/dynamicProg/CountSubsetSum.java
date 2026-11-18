package com.coding.dynamicProg;

public class CountSubsetSum {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1};
        int target = 1;

            System.out.println(countSum(arr,target,arr.length));
        }

    private static int countSum(int[] arr, int sum, int n) {
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] =1;
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    //exclude
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] =dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

}
