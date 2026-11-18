package com.hackkerank;

public class maxStorageEfficiency {

    public static void main(String[] args) {

        int [] segments = {10,20,30};
        int m = 6;

        int total =0;
        int max = Integer.MIN_VALUE;

        for(int seg:segments){
            total+=seg;
            max = Math.max(seg,max);
        }

        System.out.println(total);
        System.out.println(max);

        if(total<m){
            System.out.println(-1);
        }

        int left = 1;
        int right = max;
        int ans =-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(canProcess(segments,mid,m)){
                ans = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }

        System.out.println(ans);
    }

    public static boolean canProcess(int [] segments, int mid, int m){
        int count =0;
        for(int seg: segments){
           count+= seg/mid;
        }
        return count>=m;
    }
}
