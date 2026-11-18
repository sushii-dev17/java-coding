package com.coding.dynamicProg;

public class findsubSetSum {

    public static void main(String[] args) {

        int arr [] = {3, 34, 4, 12, 5, 2};
        int sum = 3;

        int n = arr.length;
        boolean [][] dp = new boolean[n+1][sum+1];

        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            dp[i][0] = true;
            for(int j=1;j<=sum;j++){
                System.out.println("arr[i-1]: " +arr[i-1]);
                if(arr[i-1]>j){
                    System.out.println("i and j value :"+i+","+j+"dp[i-1][j]: "+dp[i-1][j]);
                    dp[i][j] = dp[i-1][j];
                 //   System.out.println("of if: "+dp[i][j]);
                }
                else{
                    System.out.println("i and j value :"+i+","+j+"dp[i-1][j]: "+dp[i-1][j]);
                    boolean exclude = dp[i-1][j];
                    System.out.println("i and j and arr[i-1] value :"+i+","+j+","+arr[i-1]+" dp[i-1][j-arr[i-1]]: "+dp[i-1][j-arr[i-1]]);
                    boolean include =dp[i-1][j-arr[i-1]];
                    dp[i][j] = exclude||include;
                  //  System.out.println("of else: "+dp[i][j]);
                }

            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        System.out.println(dp[n][sum]);

   //     System.out.println(findsubSetSumMehtod(arr,sum,arr.length));
    }

    private static boolean findsubSetSumMehtod(int[] arr, int sum, int n) {
        if(sum ==0){
            return true;
        }
        if(n ==0){
            return false;
        }
        if(arr[n-1]>sum){
            return findsubSetSumMehtod(arr,sum,n-1);
        }
        return findsubSetSumMehtod(arr,sum-arr[n-1],n-1)||findsubSetSumMehtod(arr,sum,n-1);
    }

}
