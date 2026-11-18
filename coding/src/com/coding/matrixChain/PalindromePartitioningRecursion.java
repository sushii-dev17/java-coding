package com.coding.matrixChain;

import java.util.Arrays;

public class PalindromePartitioningRecursion {


    public static void main(String[] args) {
        String s = "nitik";
        int len = s.length();

        int [][] dp = new int[len+1][len+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int res = palindromePartRec(s, 0, s.length() - 1,dp);
        System.out.println(res);
    }

    public static int palindromePartRec(String s,int i, int j,int[][]dp){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int minVal = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int left,right;
            if(dp[i][k]!=-1){
                left = dp[i][k];
            }else{
                left =palindromePartRec(s,i,k,dp);
            }
            if(dp[k+1][j]!=-1){
                right = dp[k+1][j];
            }else{
               right= palindromePartRec(s,k+1,j,dp);
            }
            int temp = left +right +1;
           if(temp<minVal){
               minVal = temp;
           }
        }
        return minVal;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }


}
