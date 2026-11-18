package com.coding.dynamicProg;

public class TargetSum {

    public static void main(String[] args) {

        int [] arr ={1,1,2,3};
        int diff = 1;
        int sum =0;
        for(int i=0;i<arr.length;i++){

            sum += arr[i];
        }
        int subset1 = (diff+sum)/2;

        System.out.println(findsubSetSum(arr,subset1,arr.length));
    }

    public static int findsubSetSum(int [] arr, int sum,int n){
        int [][] dp = new int[n+1][sum+1];

        dp[0][0] =1;
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
            for(int j=1;j<=sum;j++){

                if(arr[i-1]>j){
                    System.out.println("dp[i-1][j]: " +dp[i-1][j]);
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    System.out.println("dp[i-1][j]: " +dp[i-1][j]+"-"+"dp[i-1][j-arr[i-1]]: "+dp[i-1][j-arr[i-1]]);
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
