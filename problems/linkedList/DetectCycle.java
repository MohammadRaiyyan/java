package problems.linkedList;

import problems.linkedList.LL.Node;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {
  public static boolean hasCycleBrute(Node head) {
    Map<Node, Integer> map = new HashMap<>();
    Node temp = head;
    while (temp != null) {
      if (map.get(temp) != null) {
        return true;
      } else {
        map.put(temp, 1);
      }
      temp = temp.next;
    }
    return false;
  }

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
