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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        
        // find middle
        ListNode midNode=mid(head);
        
        // reverse second half
        ListNode secondHead=reverse(midNode);

        // compare both halves
        ListNode first=head;
        ListNode second=secondHead;

        while(second != null){
            if(first.val != second.val)
                return false;

            first = first.next;
            second = second.next;
        }
       return true;
    }

    // find midNode
    public ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // reverse the 2nd half
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

}