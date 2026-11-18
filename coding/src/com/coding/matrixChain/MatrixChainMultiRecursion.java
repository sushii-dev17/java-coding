package com.coding.matrixChain;

public class MatrixChainMultiRecursion {


    public static void main(String[] args) {

        int [] arr = {2, 1, 3, 4};

        //find min cost

        int solve = solve(arr, 1, arr.length - 1);

        System.out.println("solve : "+solve);
    }

    public static int solve(int [] arr, int i, int j){
        System.out.printf("getting value of i: %d and j: %d:",i,j);
        System.out.println();
        if(i>=j){
            return 0;
        }

        int min =Integer.MAX_VALUE;

        System.out.println("min value :"+min);

        for(int k =i;k<=j-1;k++){

            int left = solve(arr, i, k);
            System.out.println("left: "+left);
            int right = solve(arr,k+1,j);
            System.out.println("right: "+right);
            int temp = left +
                   right+
                    arr[i-1]*arr[k]*arr[j];
            System.out.println("temp value :" +temp);

            if(temp<min){
                min = temp;
            }
        }
        return min;
    }
}
