package com.coding.unBoundKnap;

public class CoinChange1 {

    public static void main(String[] args) {

        int []coin = {1,2,3};
        int sum =5;

        int n = coin.length;
        int [][] dp = new int[n+1][sum+1];

        dp[0][0] =1;
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
            for(int j=1;j<=sum;j++){
                if(coin[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    int include = dp[i][j - coin[i - 1]];
                    int exclude=dp[i-1][j];
                    dp[i][j] = include+exclude;
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
