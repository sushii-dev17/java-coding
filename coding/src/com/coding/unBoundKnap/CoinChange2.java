package com.coding.unBoundKnap;

public class CoinChange2 {

    public static void main(String[] args) {

        int []coin = {1,2,3};
        int sum =5;

        int n = coin.length;
        int [][] dp = new int[n+1][sum+1];

        dp[0][0] =Integer.MAX_VALUE-1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[0][j] = Integer.MAX_VALUE-1;
                if (coin[0] % j == 0) {
                    dp[1][j] = j / coin[0];
                } else {
                    dp[1][j] = Integer.MAX_VALUE - 1;
                }
                if(coin[i-1]>j){
                    System.out.println("value of i and j are: "+i+j+"--"+dp[i-1][j]);
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    System.out.println("value of i and j are: "+i+(j - coin[i - 1])+"--"+dp[i][j - coin[i - 1]]);
                    int include = 1+dp[i][j - coin[i - 1]];
                    System.out.println("value of i and j are: "+i+j+"--"+dp[i-1][j]);
                    int exclude=dp[i-1][j];
                    dp[i][j] = Math.min(include,exclude);
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
