package com.coding.lcs;

public class MinInsertionLongestPalindromSubSeq {

    public static void main(String[] args) {

        String a = "agbcba";  //op - 5
        String b = new StringBuilder(a).reverse().toString();

        System.out.println(b);

         int m = a.length();
         int n = b.length();

         int [][]dp = new int[m+1][n+1];
        int lcs = lengthLCS(a,b,m,n,dp);
        System.out.println(lcs);

        //min deletion to make it a lps

        int insertion = a.length() - lcs;

        System.out.println("min insertion to make it a lps: "+ insertion);

        StringBuilder result =new StringBuilder();

        int i=m,j =n;

        while (i>0 && j>0){
            if (a.charAt(i-1) == b.charAt(j-1)) {
                result.append(a.charAt(i-1));
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

        String lcsOp =result.reverse().toString();
        System.out.println(lcsOp);

    }

    private static int lengthLCS(String a, String b, int m, int n,int [][]dp) {
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
