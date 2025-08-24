package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class RemoveDuplicateFromSortedList {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3, 3};
    Node head = ConvertArrayToLL.convertToLL(nums);
    ConvertArrayToLL.printLLElements(removeDuplicate(head));
  }

  static Node removeDuplicate(Node head) {
    Node temp = head;
    while (temp != null && temp.next != null) {
      if (temp.data == temp.next.data) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return head;
  }
}
