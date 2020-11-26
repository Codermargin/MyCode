package com.xyx.DailyLeetCode;

public class insertionSortList_147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = insertionSortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 链表排序（插入排序）
     * 【思路】维护一个已经排序好的链表节点，并且通过curr遍历完所有的节点
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        //设置一个哨兵节点，用于后续的插入
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode sortedListNode = head;
        ListNode curNode = head.next;
        while (curNode != null){
            if (sortedListNode.val <= curNode.val){
                //若排序好节点的值小于当前要排序的节点的值
                //直接插入即可
                //【注】只有有序链表后节点小于前序节点才需要执行更新sortedListNode操作
                sortedListNode = sortedListNode.next;
            }else {
                //大于
                //从哨兵节点后面开始遍历插入,preNode标记哨兵节点
                ListNode preNode = dummyHead;
                while (preNode.next.val <= curNode.val){
                    //找插入的位置
                    preNode = preNode.next;
                }
                //执行插入操作
                sortedListNode.next = curNode.next; //放入排序好的后面那个节点
                curNode.next = preNode.next;
                preNode.next = curNode;
            }
            curNode = sortedListNode.next;
        }
        return dummyHead.next;
    }
}
