// 2.6: Palindrome: implement a function to check if a linked list is a palindrome.

public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
}

public class LinkedListPalindromeChecker {

    public static void main(String[] args) {
        // Test with a palindrome list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        System.out.println(isPalindrome(node1)); // true
    }
    
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half
        ListNode prev = null, curr = slow, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Compare the first half and the reversed second half
        ListNode p1 = head, p2 = prev;
        boolean isPalindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // Optional: Restore the original list by reversing the second half back
        curr = prev;
        prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return isPalindrome;
    }
}