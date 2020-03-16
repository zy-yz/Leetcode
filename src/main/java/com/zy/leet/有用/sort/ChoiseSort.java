package com.zy.leet.有用.sort;

public class ChoiseSort {
    public static int[] sort(int[] array){
        for (int i = 0;i<array.length;i++){
            int min = i;
            for (int j = i+1;j<array.length;j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
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
