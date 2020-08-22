/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null)
            return null;

        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carry =0;

        while(l1 != null || l2 != null) {
            int a = (l1 != null)? l1.val: 0;
            int b = (l2 != null)? l2.val: 0;
            l3.next = new ListNode((a+b+carry)%10);
            carry = (a+b+carry)/10;
            if(l1 != null) {l1 = l1.next;}
            if(l2 != null) {l2 = l2.next;}
            l3 = l3.next;
        }

        if(carry>0){
            l3.next = new ListNode(carry);
        }
        return head.next;
    }
}

//timecompexity O(max(l1,l2)
// space compexlity O(max(l1,l2)

// approach. normal iteration through the lists and add each value. Points to remeber: we need to parse
// end of two lists and handle when different list sizes.
// careful with carry.
