package com.coding.lcs;
public class LcsTopDown {
    public static void main(String[] args) {

         String x = "abcdgh";
         String y = "abedfhr";
         int xLen = x.length();
         int yLen = y.length();
         int [][] dp = new int[xLen+1][yLen+1];

         for(int i =1;i<=xLen;i++){
             for(int j =1;j<=yLen;j++) {
                 if (x.charAt(i - 1) == y.charAt(j - 1)) {
                     dp[i][j] = 1 + dp[i - 1][j - 1];
                 } else {
                     int include = dp[i - 1][j];
                     int exclude = dp[i][j - 1];
                     dp[i][j] = Math.max(include, exclude);
                 }
             }
         }

        System.out.println(dp[xLen][yLen]);

    }
}
