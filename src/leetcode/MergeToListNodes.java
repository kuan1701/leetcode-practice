package leetcode;

/**
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 * Return the head of the merged linked list.
 **/
public class MergeToListNodes {
  public static void main() {
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(3);
    head1.next.next = new ListNode(5);

    ListNode head2 = new ListNode(2);
    head2.next = new ListNode(4);
    head2.next.next = new ListNode(6);

    System.out.println("ListNode 1");
    printListNode(head1);

    System.out.println();

    System.out.println("ListNode 2");
    printListNode(head2);

    System.out.println();

    System.out.println("Merged list");
    ListNode mergedList = mergeTwoLists(head1, head2);
    printListNode(mergedList);
  }

  private static class ListNode {
    int value;
    ListNode next;

    ListNode (int value) {
      this.value = value;
      this.next = null;
    }
  }

  // Function to merge two sorted linked lists
  private static ListNode mergeTwoLists(ListNode head1, ListNode head2) {

    // Create a dummy node to act as the starting point
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    // Traverse both lists and compare nodes
    while (head1 != null && head2 != null) {
      if (head1.value <= head2.value) {
        current.next = head1;
        head1 = head1.next;
      } else {
        current.next = head2;
        head2 = head2.next;
      }
      current = current.next;
    }

    // If one list is exhausted, link the remaining nodes of the other list
    current.next = head1 != null ? head1 : head2;

    // The merged list starts from the next node of the dummy node
    return dummy.next;
  }

  private static void printListNode(ListNode listNode) {
    ListNode temp = listNode;
    while (temp != null) {
      String currentString = temp.next != null ? temp.value + " -> " : String.valueOf(temp.value);
      System.out.print(currentString);
      temp = temp.next;
    }
  }
}
