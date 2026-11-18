package com.coding.lcs;

public class LcsMemoization {

    static String x = "abcdgh";
    static String y = "abedfhr";
    static int xLen = x.length();
    static int yLen = y.length();
    static int [][] dp = new int[xLen+1][yLen+1];
    public static void main(String[] args) {

        System.out.println(xLen+"-----"+yLen);

        for(int i=1;i<=xLen;i++){
            for(int j=1;j<=yLen;j++){
                dp[i][j] = -1;
            }
        }

        for(int i=1;i<=xLen;i++){
            for(int j=1;j<=yLen;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }

        System.out.println(findLcsRecursion(x,y,xLen,yLen));
    }
    private static int findLcsRecursion(String x, String y, int xLen, int yLen) {
        if(xLen ==0 || yLen ==0){
            return 0;
        }
        if(dp[xLen][yLen] !=-1){
            return dp[xLen][yLen];
        }
        if(x.charAt(xLen-1) == y.charAt(yLen-1)){
            dp[xLen][yLen] = 1+findLcsRecursion(x,y,xLen-1,yLen-1);
        }
        else{
            dp[xLen][yLen] = Math.max(findLcsRecursion(x,y,xLen-1,yLen),
                    findLcsRecursion(x,y,xLen,yLen-1));
        }
        return dp[xLen][yLen];
    }
}
