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

    @Override
    public int[] QuickSort(int[] arr, int start, int end) {
        if (start < end) {
            //把数组的第0个数作为标准数
            int stared = arr[start];
            //记录要排序的下标
            int low = start;
            int height = end;
            //循环找出比标准数大和比标准数小的数
            while (low < height) {
                //右边数字比标准数大
                while (low < height && stared <= arr[height]) {
                    height--;
                }
                //用右边的数字替换左边的数字
                arr[low] = arr[height];
                //左边数字比标准数小
                while (low < height && stared >= arr[low]) {
                    low++;
                }
                //用左边的数字替换右边的数字
                arr[height] = arr[low];
            }
            arr[low] = stared;
            QuickSort(arr, start, low);
            QuickSort(arr, low + 1, height);
        }
        return arr;

    }
}
