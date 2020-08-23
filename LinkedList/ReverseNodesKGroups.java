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
class ReverseNodesKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;
        while(ptr != null && count < k){
            ptr = ptr.next;
            count++;
        }
        if(count == k){
            ListNode reversehead = reverse(head,k);
            head.next = reverseKGroup(ptr,k);
            return reversehead;
        }
        return head;
    }

    public ListNode reverse(ListNode head, int k){

        ListNode curr = null;
        ListNode prev = null;

        while(k >0){
            curr = head;
            head = head.next;
            curr.next = prev;
            prev = curr;
            k--;
        }
        return curr;
    }
}

// time complexity : O(n)
// space Compexlity : O(n)

// use recurseive logic to find reverse lists in groups.
// and recursion is group is similar to linked list reverse
