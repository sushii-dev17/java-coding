package com.coding;

import java.util.Arrays;

public class MergeSortAlgo {

    public static void main(String[] args) {
        
        int [] arr = {9,8,4,5,11,1,2,6,3};

        int[] merge = merge(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(merge));
    }
    
    public static int [] merge(int []arr,int start,int end){
        
        if(start>=end){
            return arr;
        }
        int mid = (start+end)/2;
        merge(arr,start,mid);
        merge(arr,mid+1,end);
        return mergeSort(arr,start,mid,end);
    }

    public static int [] mergeSort(int []arr,int start,int mid,int end){
        
        int i = start;
        int j = mid+1;
        int len = (end-start)+1;
        int k =0;
        int []res = new int[len];
        
        while(i<=mid && j <=end){
            if(arr[i]>arr[j]){
                res[k] = arr[j];
                j++;
            }else{
                res[k] = arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j<=end){
            res[k] = arr[j];
            j++;
            k++;
        }

        for(int p =0;p<res.length;p++){
            arr[start] = res[p];
            start++;
        }
        return arr;
    }
}
