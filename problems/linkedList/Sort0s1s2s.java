package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class Sort0s1s2s {
  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 1, 0, 2, 0, 1, 2};
    Node head = ConvertArrayToLL.convertToLL(nums);
    head = sortBetter(head);
    ConvertArrayToLL.printLLElements(head);
  }

  static Node sortBetter(Node head) {
    Node dummyL0 = new Node(-1);
    Node dummyL1 = new Node(-1);
    Node dummyL2 = new Node(-1);
    Node l0 = dummyL0;
    Node l1 = dummyL1;
    Node l2 = dummyL2;
    Node curr = head;
    while (curr != null) {
      if (curr.data == 0) {
        l0.next = curr;
        l0 = l0.next;
      } else if (curr.data == 1) {
        l1.next = curr;
        l1 = l1.next;
      } else {
        l2.next = curr;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    l0.next = dummyL1.next;
    l1.next = dummyL2.next;
    l2.next = null;
    return dummyL0.next;
  }

  static Node sort(Node head) {
    Node curr = head;
    int count0 = 0;
    int count1 = 0;
    while (curr != null) {
      if (curr.data == 0) {
        count0++;
      } else if (curr.data == 1) {
        count1++;
      }
      curr = curr.next;
    }
    curr = head;
    while (curr != null) {
      if (count0 > 0) {
        curr.data = 0;
        count0--;
      } else if (count1 > 0) {
        curr.data = 1;
        count1--;
      } else {
        curr.data = 2;
      }
      curr = curr.next;
    }
    return head;
  }
}
