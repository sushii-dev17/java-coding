package com.coding.dynamicProg;

public class CountSubsetSumRecursion {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1};
        int target = 1;
            System.out.println(countSum(arr,target,arr.length));
        }

    private static int countSum(int[] arr, int sum, int n) {
        if(sum ==0){
            return 1;
        }
        if(n ==0){
            return 0;
        }

        if(arr[n-1]>sum){
            return countSum(arr,sum,n-1);
        }
        else{
            return countSum(arr,sum,n-1)+countSum(arr,sum-arr[n-1],n-1);
        }
    }

}
