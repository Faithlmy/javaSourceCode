package com.dataStructure.sort;

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
                if (num[j] < num[minIndex]) {
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

        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //将堆顶元素与末尾元素进行交换，此时末尾就为最大值，将最大值全放在数组最后
        //重新调整结构，使其满足堆定义，继续交换堆顶元素与当前末尾元素，反复执行调整交换步骤，使整个序列达到有序
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组" + Arrays.toString(arr));
        return new int[0];

    }



    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量中
        //开始调整
        //k=i*2+1;k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {//如果子节点大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//!!!i指向k，继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，已经将以i为父结点的最大值放在了堆顶上（局部）
        arr[i] = temp;//将temp的值放在调整后的位置
    }


    @Override
    public int[] MergeSort(int[] arr) {
        _mergeSort(arr, 0, arr.length);
        return null;
    }

    // right - left 为区间中的元素个数
    public static void _mergeSort(int[] arr, int left, int right){
        if(right - left <= 1){
            //如果当前待排序的区间里只有一个元素，或者没有元素
            //就直接返回，不需要任何排序动作
            return;
        }
        //先把当前 [left, right) 区间一分为二
        int mid = (left + right) / 2;
        //分成了两个区间
        //[left, mid)  [mid, right)
        //当左侧区间的  _mergeSort 执行完毕后，
        //就认为 [left, mid) 就已经是有序区间了
        _mergeSort(arr, left, mid);
        //当右侧区间的  _mergeSort 执行完毕后，
        //就认为 [mid, right) 就已经是有序区间了
        _mergeSort(arr, mid, right);
        //接下来把左右两个有序数组，合并到一起！
        merge(arr, left, mid, right);
    }

    // merge 方法本身功能是把两个有序数组合并成一个有序数组。
    // 待合并的两个数组就分别是：
    // [left, mid)
    // [mid, right)
    public static void merge(int[] arr, int left, int mid, int right) {
        //创建一个临时的数组，用来存放合并结果
        //我们是希望这个数组能存下合并后的结果  right - left
        int[] tmp = new int[right - left];
        //当前要把新的数组元素放到 tmp 数组的哪个下标上
        int tmpSize = 0;
        int l = left;
        int r = mid;
        while (l < mid && r < right) {
            //归并排序是稳定排序！！！
            //此处的条件不要写作 arr[l] < arr[r]
            if (arr[l] <= arr[r]) {
                //arr[l]比较小，就把这个元素先插入到 tmp 数组末尾
                tmp[tmpSize] = arr[l];
                tmpSize++;
                l++;
            } else {
                //arr[r] 比较小，就把这个数组插入到 tmp 数组末尾
                tmp[tmpSize] = arr[r];
                tmpSize++;
                r++;
            }
        }
        //当其中一个数组遍历完了之后，就把另外一个数组的剩余部分都拷贝到 临时空间tmp
        while (l < mid) {
            //剩下的都是左半边数组
            tmp[tmpSize] = arr[l];
            tmpSize++;
            l++;
        }
        while (r < right) {
            //剩下的是右半边数组
            tmp[tmpSize] = arr[r];
            tmpSize++;
            r++;
        }
        //最后一步，再把临时空间的内容都拷贝回参数数组
        //需要把 tmp 中的内容拷贝回 arr 的 [left, right) 这一段空间里
        // [left, right) 这个空间很可能不是从 0 开始的
        for (int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
    }

}





