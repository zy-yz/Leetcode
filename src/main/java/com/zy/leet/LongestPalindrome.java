package com.zy.leet;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {


    //解法1,暴力解法
    //时间复杂度,两层for循环O(n2),for循环判断为回文O(n),所以时间复杂度为O(n3)
    public static String longestPalindrome(String s) {

        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //动态规划
    //时间复杂度：两层循环 O(n²)
    //
    //空间复杂度：一个二维数组 O(n²)
    public static String longestPalindrome2(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        //字符串倒转
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i; //以i位置结尾的字符
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    //将二维数组改为一维数组
    //时间复杂度 O(n²)
    //
    //空间复杂度降为 O(n)
    public static String longestPalindrome3(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {

                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }

                    //之前二维数组，每次用的是不同的列，所以不用置 0 。
                } else {
                    arr[j] = 0;
                }
                /**************************************************/
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }

                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
    }

}
