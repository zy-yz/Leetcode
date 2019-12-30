package com.zy.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串
 * */
public class Convert {
    public static String convert(String s,int numRows){
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        int i=0,flag = -1;
        for(char c: s.toCharArray()){
            rows.get(i).append(c);
            if(i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i +=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int num = 3;
        convert(s,num);
        System.out.println(convert(s,num));
    }
}
