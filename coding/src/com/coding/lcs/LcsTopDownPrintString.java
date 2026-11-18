package com.coding.lcs;
public class LcsTopDownPrintString {
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
         StringBuilder result =new StringBuilder();

         int i=xLen,j =yLen;

         while (i>0 && j>0){
             if (x.charAt(i-1) == y.charAt(j-1)) {
                 result.append(x.charAt(i-1));
                 i--;
                 j--;
             }
             else{
                if(dp[i-1][j]<dp[i][j-1]){
                    j--;
                }else{
                    i--;
                 }
             }
         }

        System.out.println(result.reverse());


    }
}
