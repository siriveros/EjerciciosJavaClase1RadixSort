package com.team.itb.wave8.sortdemo;

import com.team.itb.wave8.sortdemo.negocio.RadixSort;

public class Main {

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8 , 12,31231,23311,1132221};

        arr = RadixSort.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }

        System.out.println("\n============================================");

        String arr2[] = {"simon","CAse","casa","prueba","VIdeojuegos"};

        arr2 = RadixSort.sort(arr2);

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + (i < arr2.length - 1 ? "," : ""));
        }
    }
}
