package com.coding;

public class PrimeNum {

    public static void main(String[] args) {

        int n = 100;
        int i, j;
        int count = 0;
        for (i = 2; i < n; i++) {
            count = 0;
            for (j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(i);
            }
        }
    }
}
