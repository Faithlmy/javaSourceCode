package com.vic.dataStructure;

public class LarryArrayApp {
    public static void main(String[] args) {

    }
}

class LowArray{
    private Long[] arr;

    private long size;

    public LowArray(int size){
        arr = new Long[size];
    }

    public long getValue(int index){
        return arr[index];
    }

    public void setValue(int index, long value){
        arr[index] = value;
        size++;
    }

    public long getSize(){
        return size;
    }

    // 删除指定位置上的元素
    public boolean deleteIndexValue(int index){
        if (index < 0 || index > size){
            return false;
        }
        if (index == size){
            size--;
        }else{
            arr[index] = arr[index + 1];
            size--;
        }
        return true;
    }

    // 按照元素删除，有重复的一起删除
    public void delateAllValue(long value){
        // 找删除元素在原数组中的位置
        for (int i = 0; i < size; i++){
            if (arr[i] == value){
                deleteIndexValue(i);
            }
        }
    }

}