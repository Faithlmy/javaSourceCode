package com.vic.dataStructure.sort;

import java.util.Arrays;

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

    @Override
    public int[] HeapSort(int[] arr) {

        int temp=0;
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素进行交换，此时末尾就为最大值，将最大值全放在数组最后
        //重新调整结构，使其满足堆定义，继续交换堆顶元素与当前末尾元素，反复执行调整交换步骤，使整个序列达到有序
        for(int j=arr.length-1;j>0;j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组"+ Arrays.toString(arr));
        return new int[0];

    }





    public static void adjustHeap(int[]arr,int i,int length){
        int temp=arr[i];//先取出当前元素的值，保存在临时变量中
        //开始调整
        //k=i*2+1;k是i节点的左子节点
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){//说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if(arr[k]>temp){//如果子节点大于父节点
                arr[i]=arr[k];//把较大的值赋给当前节点
                i=k;//!!!i指向k，继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束后，已经将以i为父结点的最大值放在了堆顶上（局部）
        arr[i]=temp;//将temp的值放在调整后的位置
    }

}



