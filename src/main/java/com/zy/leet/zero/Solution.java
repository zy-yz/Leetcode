package com.zy.leet.zero;


//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
// 并且它们的每个节点只能存储 一位 数字。
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Email: 1090712762@qq.com
 * @Author: Rattan Pepper
 * @Date: 2019/12/15
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先将链表补充为同样长度,
        //每一位进位的时候都要考虑上一位进位问题
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;//进位
        while (p != null || q != null) //遍历链表，直到两个链表都都遍历的底
        {
            int x = (p != null) ? p.val : 0;//x为当前链表节点P的值，如果链表已经到底了，就取0
            int y = (q != null) ? q.val : 0;//y为当前链表节点Q的值，如果链表已经到底了，就取0
            int sum = carry + x + y;//sum为当前两位以及上两个节点的进位的和
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);//得到正确的值放入新链表
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) //如果最后还有一个进位，把进位再加上
        {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;//dummyHead是一个空的头节点
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}