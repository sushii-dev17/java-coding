package com.coding.lcs;

public class LongestRepeatingSuperSeq {

    static String a = "aabebcdd";
    static String b = "aabebcdd";
    static int m = a.length();
    static int n = b.length();

   static int [][]dp = new int[m+1][n+1];

    public static void main(String[] args) {

        int lcsLength = lengthLCS(a,b,m,n);
        System.out.println(lcsLength);
        int lengthSuperSequence = (m+n) - lcsLength;
        System.out.println("length of shortest common supersequence :"+lengthSuperSequence);

        int i =m;
        int j =n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(a.charAt(i-1) == b.charAt(j-1) && i!=j){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]<dp[i][j-1]){
                    j--;
                }else{
//                    sb.append(a.charAt(i-1));
                    i--;
                }
            }
        }

        while (i>0){
            sb.append(a.charAt(i-1));
            i--;
        }
        while (j>0){
            sb.append(b.charAt(j-1));
            j--;
        }

        System.out.println(sb.reverse());
    }

    private static int lengthLCS(String a, String b, int m, int n) {
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1) && i !=j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
