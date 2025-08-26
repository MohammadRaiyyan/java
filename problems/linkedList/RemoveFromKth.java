package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class RemoveFromKth {
  public static void main(String[] args) {
    Node head = ConvertArrayToLL.convertToLL(new int[]{1, 2, 3, 4, 5});
    ConvertArrayToLL.printLLElements(removeNthFromEndOptimal(head, 2));
  }

  static Node removeNthFromEndOptimal(Node head, int n) {
    Node dummyNode = new Node(0, head);
    Node fast = dummyNode;
    Node slow = dummyNode;
    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    if (slow != null && slow.next != null) {
      slow.next = slow.next.next;
    }
    return dummyNode.next;
  }

  static Node removeNthFromEnd(Node head, int n) {
    Node temp = head;
    int count = 0;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    if (count == n) {
      return head.next;
    }
    int target = count - n;
    temp = head;
    for (int i = 1; i < target; i++) {
      temp = temp.next;
    }
    if (temp != null && temp.next != null) {
      temp.next = temp.next.next;
    }
    return head;
  }
}
