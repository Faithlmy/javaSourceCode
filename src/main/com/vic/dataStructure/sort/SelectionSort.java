package com.vic.dataStructure.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int []  arr = new int[]{3,1,4,62,2,6};
        s.sort(arr);
    }

    public void sort(int [] arr){
        // 选择排序 1、用一个临时变量存放指针位置。2、不断比较找到最小的指针位置 ，然后交换。
        for(int i = 0  ; i < arr.length ; i ++){
            int temp = i ;
            for(int j =i ; j<arr.length;j++){
                // 比较 如果当前 temp的指针小于j 则交换
                if(arr[temp]>arr[j]){
                    temp=j;
                }
            }
            // 此时temp应该是最小的指针
            if(i!=temp){
                // 此处经典的是值传递，
                // 因为拷贝的值，值换了 ，但是 arr[i]的引用没换
                //  Util.swap(arr[i],arr[temp]);
                int value = arr[i];
                arr[i] =arr[temp];
                arr[temp] = value;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("第"+i+"轮");
        }
    }
}
