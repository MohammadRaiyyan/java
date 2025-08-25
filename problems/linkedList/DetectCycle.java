package problems.linkedList;

import problems.linkedList.LL.Node;

public class DetectCycle {
  public boolean hasCycle(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
