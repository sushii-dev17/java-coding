package com.hackkerank;

import java.util.Arrays;

public class ProcessAllocation {

    public static void main(String[] args) {

        int[] processSize = {1,2,3,4,6};
        int [] capacity = {4,7,4};

        Arrays.sort(processSize);
        Arrays.sort(capacity);
        int ans =-1;
        if(processSize[processSize.length-1]>capacity[capacity.length-1]){
            System.out.println(ans);
        }

        int left = 1;
        int right = 2*processSize.length;


        while(left<=right){
            int mid = left + (right-left)/2;

            if(canFinish(processSize,capacity,mid)){
                ans = mid;
                right = mid-1;
            }
            else{
                left =mid+1;
            }
        }

        System.out.println(ans);
    }

    public static boolean canFinish(int [] processSize, int [] capacity, int time){
        int maxPerProcess = (time+1)/2;
        System.out.println(maxPerProcess);
        int processIndex =0;

        for(int cap:capacity){
            int count =0;
            while (processIndex<processSize.length&&
            processSize[processIndex]<=cap
            && count <maxPerProcess){
                System.out.println(processSize[processIndex]);
                System.out.println(cap);
                processIndex++;
                count++;
            }
        }
        return processIndex == processSize.length;
    }
}
