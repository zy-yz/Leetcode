package com.zy.leet.有用.sort;

public class QuickSort {
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        //取第⼀个元素为基准值
        int pivot = arr[startIndex];
        while (true){
            while (arr[left] <= arr[pivot]){
                left++;
                if(left == right){
                    break;
                }
            }
            //从右往左扫描
            while (pivot < arr[right]) {
                right--;
                if (left == right) {
                    break;
                }
            }
            //左右指针相遇
            if (left >= right) {
                break;
            }
            //交换左右数据
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        //将基准值插⼊序列
        int temp = arr[startIndex];
        arr[startIndex] = arr[right];
        arr[right] = temp;
        return right;

    }
    public static void sort(int[] arr) {
        sort(arr,0,arr.length - 1);
    }
    private static void sort(int[] arr,int startIndex,int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
//切分
        int pivotIndex = partition(arr,startIndex, endIndex);
        sort(arr,startIndex,pivotIndex-1);
        sort(arr,pivotIndex+1,endIndex);
    }
}
