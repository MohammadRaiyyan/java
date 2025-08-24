package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class Sort0s1s2s {
  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 1, 0, 2, 0, 1, 2};
    Node head = ConvertArrayToLL.convertToLL(nums);
    head = sort(head);
    ConvertArrayToLL.printLLElements(head);
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
