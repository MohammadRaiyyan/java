package problems.linkedList;

import problems.linkedList.LL.Node;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLL {
  static Node getIntersectionPoint(Node headA, Node headB) {
    Map<Node, Integer> map = new HashMap<>();
    Node temp = headA;
    while (temp != null) {
      map.put(temp, map.getOrDefault(temp, 0) + 1);
      temp = temp.next;
    }
    temp = headB;
    while (temp != null) {
      Integer node = map.get(temp);
      if (node != null) {
        return temp;
      }
      temp = temp.next;
    }
    return null;

  }

  static Node getInterSectionPointTwo(Node headA, Node headB) {
    // Count both the length
    Node a = headA;
    int h1Count = 0;
    Node b = headB;
    int h2Count = 0;
    while (a != null) {
      h1Count++;
      a = a.next;
    }
    while (b != null) {
      h2Count++;
      b = b.next;
    }
    int d = Math.abs(h1Count - h2Count);
//Take the largest as a and smallest as b, because will run on a to make the both pointer pointing on same position
    a = h1Count > h2Count ? headA : headB;
    b = h1Count > h2Count ? headB : headA;
    while (d != 0) {
      d--;
      a = a.next;
    }
    while (a != null && b != null) {
      if (a == b) {
        return a;
      }
      a = a.next;
      b = b.next;
    }
    return null;
  }

  static Node getIntersectionPointThree(Node headA, Node headB) {
    Node t1 = headA;
    Node t2 = headB;
    while (t1 != t2) {
      t1 = t1.next;
      t2 = t2.next;
      if (t1 == t2) {
        return t1;
      }
      if (t1 == null) {
        t1 = headB;
      }
      if (t2 == null) {
        t2 = headA;
      }
    }
    return t1;
  }

}
