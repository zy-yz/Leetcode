package com.zy.leet.twenty;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {

    //深度优先遍历
    //做减法
    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        //特判
        if(n == 0){
            return res;
        }
        //执行深度优先遍历,搜索可能的结果
        dfs("",n,n,res);
        return res;
    }
    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String curStr,int left,int right,List<String> res){

        //因为每一次尝试,都使用新的字符串变量,所以无需回溯
        //在递归终止的时候，直接把它添加到结果集即可
        if(left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        //左括号可以使用的个数严格大于右括号可以使用的个数
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(curStr + "(",left - 1,right,res);
        }
        if(right > 0){
            dfs(curStr + ")",left,right -1,res);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(generateParenthesis(3));
    }

    //广度优先bianli
    //做加法
    public static List<String> generateParenthesis1(int n){
        List<String> res = new ArrayList<String>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }
    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, int n, List<String> res) {

        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }


    }
}
