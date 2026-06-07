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
    public ListNode sortList(ListNode head) {
        
        // base case
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=getMid(head);

        ListNode rightHead=mid.next;
        mid.next=null;  //break the list in 2 halves
        
        // recursively sort both halves
        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);

        // merge sorted halves
        return merge(left,right);
    }

    // find middle node
    private ListNode getMid(ListNode head){

        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    // merge two sorted linked lists

    private ListNode merge(ListNode l1,ListNode l2){
    
       ListNode dummy=new ListNode(-1);
       ListNode head=dummy;

       while(l1!=null && l2!=null){

        if(l1.val<l2.val){
            head.next=l1;
            l1=l1.next;
        }
        else{
            head.next=l2;
            l2=l2.next;
        }

        head=head.next;
       }

         if(l1 != null) {
            head.next = l1;
        }

        if(l2 != null) {
            head.next = l2;
        }

        return dummy.next;



    }
}