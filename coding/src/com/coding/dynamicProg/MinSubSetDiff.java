package com.coding.dynamicProg;

public class MinSubSetDiff {

    public static void main(String[] args) {
        int []arr = {1, 2,7};
        int []val = {1, 2,7};
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int max = minRange(arr, val, val.length, sum / 2);
        System.out.println(sum-2*max);
    }

    private static int minRange(int[] arr, int[] val, int n, int sum) {
        int [][] dp = new int[n+1][sum+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    System.out.print("dp[i-1][j] :"+dp[i-1][j]);
                    System.out.print(", dp[i-1][j-arr[i-1]]: "+dp[i-1][j-arr[i-1]]);
                    System.out.print(", val[i-1]: "+val[i-1]);
                   dp[i][j]= Math.max(val[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                    System.out.print(", dp[i][j]: "+dp[i][j]);
                    System.out.println();

                }
            }
        }
        return dp[n][sum];
    }
}
