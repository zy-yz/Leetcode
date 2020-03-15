package com.zy.leet.zero;

public class MaxArea {
    public static int maxArea(int[] height) {

        int max = 0;
        int temp = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                /*if(height[j] < height[i]){
                    height[i] = height[j];
                }
                temp = height[i]* (j-i);
                if(max< temp){
                    max = temp;
                }*/
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(height);
        System.out.println(maxArea(height));
        System.out.println(maxArea1(height));
    }
}
