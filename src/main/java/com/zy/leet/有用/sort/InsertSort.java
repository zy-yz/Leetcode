package com.zy.leet.有用.sort;

public class InsertSort {
    public static int[] sort(int[] array){
        int j;
        for(int i = 1;i<array.length;i++){
            int tmp = array[i];
            j = i;
            while (j>0 && tmp <array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = tmp;
        }
        return array;
    }
    //遍历显示数组
    public static void display(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array); System.out.println("-----------------------");
        System.out.println("经过排序后的数组顺序为：");
        display(array);

    }
}
