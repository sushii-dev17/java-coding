package com.coding.unBoundKnap;

public class RodCutting {

    public static void main(String[] args) {

        int []price  = {3,5,1,2};
        int length = price.length;
        int [] len = new int[length];

        int k=0;
        for(int i=1;i<=len.length;i++){
            len[k++] =i;
        }
        for(int i=0;i<len.length;i++){
            System.out.print(len[i]+",");
        }
        System.out.println();
        System.out.println(rodCuttingRecursive(price,len,length,length));
        int [][] dp = new int[length+1][length+1];

        for(int i =1;i<=length;i++){
            for(int j=1;j<=length;j++){
                System.out.println(len[i-1]);
                if(len[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int include = price[i - 1] + dp[i][j - len[i - 1]];
                    int exclude=dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }
            }
        }
        int maxProfit = dp[length][length];
        System.out.println(maxProfit);
    }

    private static int rodCuttingRecursive(int []price, int []len, int capacity, int n){
        if(n ==0 || len.length ==0){
            return 0;
        }
        if(len[n-1]>capacity){
            System.out.println("len[n-1] in if : "+len[n-1]+"  capacity: "+capacity);
            return rodCuttingRecursive(price,len,capacity,n-1);
        }
        else{
            System.out.println("len[n-1] in else : "+len[n-1]+"---- "+n+" capacity: "+capacity);
            return Math.max(price[n-1]+rodCuttingRecursive(price,len,capacity-len[n-1],n),
                    rodCuttingRecursive(price,len,capacity,n-1));
        }
    }
}
