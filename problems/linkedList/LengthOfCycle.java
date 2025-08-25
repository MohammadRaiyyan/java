package problems.linkedList;

import problems.linkedList.LL.Node;

public class LengthOfCycle {
  public int hasCycle(Node head) {
    Node fast = head;
    Node slow = head;
    int length = 0;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        Node temp = slow;
        do {
          temp = temp.next;
          length++;
        } while (temp != null);
      }
    }
    return length;
  }
}
