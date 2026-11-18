package com.coding.lcs;

public class ShortestCommonSuperSequence {

    static String a = "aggtab";
    static String b = "gxtxayb";
    static int m = a.length();
    static int n = b.length();

   static int [][]dp = new int[m+1][n+1];

    public static void main(String[] args) {

        int lcsLength = lengthLCS(a,b,m,n);
        System.out.println(lcsLength);
        int lengthSuperSequence = (m+n) - lcsLength;
        System.out.println(lengthSuperSequence);
    }

    private static int lengthLCS(String a, String b, int m, int n) {
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
