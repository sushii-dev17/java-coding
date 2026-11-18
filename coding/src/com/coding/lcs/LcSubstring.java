package com.coding.lcs;
public class LcSubstring {
    public static void main(String[] args) {

        String x = "abcde";
        String y = "abfce";
        int xLen = x.length();
        int yLen = y.length();
        int[][] dp = new int[xLen + 1][yLen + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

            System.out.println(maxLength);
            System.out.println(endIndex);
            System.out.println(x.substring(endIndex - maxLength, endIndex));
    }
}
