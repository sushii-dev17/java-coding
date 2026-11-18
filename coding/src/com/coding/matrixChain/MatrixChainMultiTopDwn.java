package com.coding.matrixChain;

public class MatrixChainMultiTopDwn {


    public static void main(String[] args) {

        int[] arr = {10,20,30,40,30};

        //find min cost

        int solve = solve(arr, 1, arr.length - 1);

       //System.out.println("solve: "+solve);
        System.out.println("matrix chain order : " + matrixChainOrder(arr));
    }

    public static int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n+1][n+1]; // dp[i][i] = 0 (single matrix)
        for (int len = 2; len < n; len++) {
            int s=n - len + 1;
            for (int i = 1; i < s; i++) {
                int r=i + len - 1;;
                int j = r;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j-1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static int solve(int[] arr, int i, int j) {
        System.out.printf("getting value of i: %d and j: %d:", i, j);
        System.out.println();
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        System.out.println("min value :" + min);

        for (int k = i; k <= j - 1; k++) {

            int left = solve(arr, i, k);
            System.out.println("left: " + left);
            int right = solve(arr, k + 1, j);
            System.out.println("right: " + right);
            int temp = left +
                    right +
                    arr[i - 1] * arr[k] * arr[j];
            System.out.println("temp value :" + temp);

            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
