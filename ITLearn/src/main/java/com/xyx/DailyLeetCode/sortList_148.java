package com.xyx.DailyLeetCode;

public class sortList_148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = sortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 链表排序（归并排序）
     * 【时间复杂度】0(nlog(n))
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        return sortListHelp(head, null);
    }

    /**
     * 归并排序的分
     *
     * @param head
     * @param tail
     * @return
     */
    public static ListNode sortListHelp(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        //定义快慢节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortListHelp(head, mid);
        ListNode list2 = sortListHelp(mid, tail);
        ListNode resultList = merge(list1, list2);
        return resultList;
    }

    /**
     * 归并排序的合
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        //没有排完的链表继续
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null){
            temp.next = temp2;
        }
        return dummyNode.next;
    }
}
