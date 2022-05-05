package com.vic.dataStructure.sort;

public class SortShow extends AbstrctSort {
    @Override
    public int[] bubleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Override
    public int[] selectSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            //注意minIndex的取值
            int minIndex = i;
            //j=i;意味着i之前的数都是有序的
            for (int j = i; j < num.length; j++) {
                if (num[j]<num[minIndex]){
                    minIndex = j;
                }
            }
            //交换，每一次循环的i都是未排序数据的第一个
            int temp = num[i];
            num[i] = num[minIndex];
            num[minIndex] = temp;
        }
        return num;
    }
}
