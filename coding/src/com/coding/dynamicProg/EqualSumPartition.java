package com.coding.dynamicProg;

public class EqualSumPartition {
    static int[] arr = {1,5,11,5};
    static int sum =0;
    public static void main(String[] args) {

        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
        }

        if(sum%2!=0){
            System.out.println(false);
        }
        else{
            System.out.println(equalSum(arr,sum/2,arr.length));
        }
    }

    private static boolean equalSum(int[] arr, int sum, int n) {
        if(sum ==0){
            return true;
        }
        if(n ==0){
            return false;
        }
        if(arr[n-1]>sum){
            return equalSum(arr,sum,n-1);
        }
        return equalSum(arr,sum-arr[n-1],n-1)||equalSum(arr,sum,n-1);
    }

}
