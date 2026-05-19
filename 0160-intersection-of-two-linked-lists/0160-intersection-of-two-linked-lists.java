/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA=getLength(headA);
        int lenB=getLength(headB);

        ListNode pA=headA;
        ListNode pB=headB;

        // align both the list
        if(lenA>lenB){
            int diff=lenA-lenB;
            while(diff-->0){
                pA=pA.next;
            }
        }

        else{
            int diff=lenB-lenA;
            while(diff-->0){
                pB=pB.next;
            }
        }

        
     // step:2 move together
            while(pA!=pB){
                pA=pA.next;
                pB=pB.next;
            }

            return pA;  //intersection node or null
        
    }

    private int getLength(ListNode head){
        int length=0;
        ListNode temp=head;

        while(temp!=null){
            temp=temp.next;
            length++;
        }

        return length;
    }
}