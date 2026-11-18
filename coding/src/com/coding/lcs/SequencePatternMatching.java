package com.coding.lcs;

public class SequencePatternMatching {

    static String a = "axy";
    static String b = "adxcpy";
    static int m = a.length();
    static int n = b.length();

   static int [][]dp = new int[m+1][n+1];

    public static void main(String[] args) {

        int lcs = lengthLCS(a,b,m,n);
        System.out.println(lcs);

        if(a.length() == lcs){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

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
