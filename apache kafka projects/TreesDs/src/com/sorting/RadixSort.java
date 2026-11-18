package com.sorting;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int [] array = {29,83,471,36,91,8};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int []arr){
        int max = Arrays.stream(arr).max().getAsInt();
        // do count sort for every digit place
        for(int exp =1;max/exp>0;exp*=10){
            countSort(arr,exp);
        }
    }

    public static void countSort(int []arr,int exp){
        int n = arr.length;
        int [] output = new int[n];
        int []count = new int[10];
       // Arrays.fill(count,0);

        //count occurance of each digit
        for(int i=0;i<n;i++){
            int digit =(arr[i]/exp)%10;
            count[digit]++;
        }
        System.out.println("Count array for "+exp+" : "+Arrays.toString(count));

        //change count[i] so that count[i] contains actual position
        for(int i=1;i<10;i++){
            count[i] = count[i]+count[i-1];
        }

        System.out.println("updated Count array for "+exp+" : "+Arrays.toString(count));

        // Build the output array (traverse backwards to maintain stability)
        for(int i=n-1;i>=0;i--){
            int digit=(arr[i]/exp)%10;
            output[count[digit]-1] =arr[i];
            count[digit]--;
        }
        System.out.println("output array :"+ Arrays.toString(arr));
        System.out.println();
        System.arraycopy(output,0,arr,0,n);
    }
}
