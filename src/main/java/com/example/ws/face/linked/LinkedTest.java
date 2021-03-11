package com.example.ws.face.linked;

import java.util.Stack;

public class LinkedTest {
    public static void main(String[] args) {

    }

    //1. 找出两个链表的交点
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2){
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
    //2链表反转
    public static ListNode reverseList(ListNode head){
        if(head == null && head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;

    }
    //2链表反转
    public static ListNode reverseListNode(ListNode head){
        if(head == null && head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        while (head != null){
            ListNode next = head.next;
            head.next = newHead.next;
            next.next = head;
            head.next = null;
        }
        return newHead.next;
    }

    // 3归并两个有序的链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
    //4从有序链表中删除重复节点
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    //5删除链表的倒数第 n 个节点
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head;
        while (n-- > 0){
            fast = fast.next;
        }
        if(head == null){
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return slow;


    }
    //6交换链表中的相邻结点
    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null || pre.next.next != null){
            ListNode l1 = pre.next,l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l2;
        }
        return node.next;
    }
    //7链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }



    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
    //8回文链表
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }
    private static void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    public static ListNode reverse(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
    public static boolean isEqual(ListNode l1,ListNode l2){
        while (l1 != null && l2 != null){
            if(l1 != l2){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
    // 9分隔链表
    public ListNode[] splitListToParts(ListNode root, int k){
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;

        ListNode[] ret = new ListNode[k];

        for (int i = 0;cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }
    //10链表元素按奇偶聚集
    public static ListNode oddEvenList(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
