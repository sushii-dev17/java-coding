package com.findRange;

import java.util.Arrays;

public class RangeMain {
    public static void main(String[] args) {
        int []arr = {1,3,5,2,7,6,3,1,4,8};

        int sum =0;
        for(int i=2;i<=7;i++){
            sum+= arr[i];
        }

        System.out.println(sum);
        int n = arr.length;
        //build a block array
        int sqrt =(int)Math.sqrt(n);
        int []blocks = new int[sqrt+1];
        int block_id=0;
        for(int i=0;i<n;i++){
            //new block starting
           // blocks[block_id]+=arr[i];
            if(i%sqrt==0 && i!=0){
                block_id++;
            }
            blocks[block_id]+=arr[i];
        }

        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks,arr,2,7,sqrt));
    }

    public static int query(int []blocks,int []arr,int left,int right,int sqrt){

        int ans =0;

        //left part
        while(left%sqrt!=0 && left<right && left!=0){
            ans += arr[left];
            left++;
        }

        //middle part

        while(left+sqrt<=right){
            ans+= blocks[left/sqrt];
            left+=sqrt;
        }
        //right
        while(left<=right){
            ans+=arr[left];
            left++;
        }
        return ans;
    }

    public static void update(int [] blocks, int []arr, int i,int newval,int sqrt){
        int block_id = i%sqrt;
        blocks[block_id]+= (newval - arr[i]);
        arr[i] = newval;
    }
}
