package com.zy.leet.twenty;


/**给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/
public class SwapPairs {

    public static  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    /**返回值：交换完成的子链表
     调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     */
    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;

    }

    public ListNode head;
    public ListNode current;

    //初始化链表,并且返回表头
    public ListNode init() {
        for(int i=0; i<10; i++) {
            this.add(i);
        }
        return head;
    }
    public void add(int data) {

        //如果头结点为空,为头结点
        if(head == null) {
            head = new ListNode(data);
            current = head;
        } else {
            current.next = new ListNode(data);
            current = current.next;
        }
    }
    //打印链表
    public void print(ListNode node) {
        if(node == null) {
            return;
        }

        current = node;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    //非递归
    public static ListNode swapPairs1(ListNode head){
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {

        SwapPairs list = new SwapPairs();
        ListNode head = list.init();
        list.print(head);
        swapPairs(head);
        System.out.println();
        list.print(head);
    }


}
