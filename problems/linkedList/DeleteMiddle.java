package problems.linkedList;

import problems.linkedList.LL.Node;

public class DeleteMiddle {
  static Node delete(Node head) {
    if (head == null || head.next == null) {
      return null;
    }
    if (head.next.next == null) {
      head.next = null;
      return head;
    }
    Node fast = head;
    Node slow = head;
    Node prev = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }
    prev.next = slow.next;
    return head;
  }
}
