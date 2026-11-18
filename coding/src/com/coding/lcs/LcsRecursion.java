package com.coding.lcs;

public class LcsRecursion {
    public static void main(String[] args) {

        String x = "abcdgh";
        String y = "abedfhr";

        int xLen = x.length();
        int yLen = y.length();

        System.out.println(findLcsRecursion(x,y,xLen,yLen));
    }

    private static int findLcsRecursion(String x, String y, int xLen, int yLen) {
        if(xLen ==0 || yLen ==0){
            return 0;
        }
        if(x.charAt(xLen-1) == y.charAt(yLen-1)){
            return 1+findLcsRecursion(x,y,xLen-1,yLen-1);
        }else{
            return Math.max(findLcsRecursion(x,y,xLen-1,yLen),
                    findLcsRecursion(x,y,xLen,yLen-1));
        }
    }
}
