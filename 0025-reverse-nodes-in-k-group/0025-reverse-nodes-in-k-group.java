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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Previous group's last node
        ListNode prevGroup = dummy;
        
        while (true) {
            
            // kth node find karo
            ListNode kth = prevGroup;
            
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            
            // Agar k nodes nahi mile
            if (kth == null) {
                break;
            }
            
            // Group start aur next group
            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;
            
            // Reverse current group
            ListNode prev = nextGroup;
            ListNode curr = groupStart;
            
            while (curr != nextGroup) {
                
                ListNode temp = curr.next;
                
                curr.next = prev;
                
                prev = curr;
                curr = temp;
            }
            
            // Previous group connect karo
            prevGroup.next = kth;
            
            // Next iteration ke liye move karo
            prevGroup = groupStart;
        }
        
        return dummy.next;
    }
}