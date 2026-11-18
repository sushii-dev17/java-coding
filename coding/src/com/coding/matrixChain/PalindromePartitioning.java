package com.coding.matrixChain;

public class PalindromePartitioning {


    public static void main(String[] args) {
        String s = "aaaa";

        int res = palindromePart(s, 0, s.length() - 1);
        System.out.println(res);
    }

    public static int palindromePart(String s,int i, int j){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        int minVal = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int left = palindromePart(s,i,k);
            int right = palindromePart(s,k+1,j);
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
