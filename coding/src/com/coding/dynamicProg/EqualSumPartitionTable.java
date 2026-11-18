package com.coding.dynamicProg;

public class EqualSumPartitionTable {
    static int[] arr = {1,5,11,5};
    static int sum =0;
    public static void main(String[] args) {

        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
        }
        if(sum%2!=0){
            System.out.println(false);
        }
        else{
            System.out.println(equalSum(arr,sum/2,arr.length));
        }
    }

    private static boolean equalSum(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=1;i<=n;i++){
            dp[i][0] = false;
            for(int j=1;j<=sum;j++){
                dp[0][j] =true;

                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

}
