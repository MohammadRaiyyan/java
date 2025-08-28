package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class Add1ToLL {
  public static void main(String[] args) {
    Node head = ConvertArrayToLL.convertToLL(new int[]{2, 3, 4});
    ConvertArrayToLL.printLLElements(addOne(head));
  }

  public static Node addOneToLinkedList(Node head) {
    Node reversedHead = reverse(head);
    Node temp = reversedHead;
    int carry = 1;
    while (temp != null) {
      temp.data = temp.data + carry;
      if (temp.data < 10) {
        carry = 0;
        break;
      } else {
        temp.data = 0;
        carry = 1;
      }
      temp = temp.next;
    }
    temp = reverse(reversedHead);
    if (carry > 0) {
      return new Node(carry, temp);
    }
    return temp;

  }

  static Node reverse(Node head) {
    Node temp = head;
    Node prev = null;
    while (temp != null) {
      Node front = temp.next;
      temp.next = prev;
      prev = temp;
      temp = front;
    }
    return prev;
  }

  static Node addOne(Node head) {
    int carry = add(head);
    if (carry > 0) {
      return new Node(carry, head);
    }
    return head;
  }

  static int add(Node head) {
    if (head == null) {
      return 1;
    }
    int carry = add(head.next);
    head.data += carry;
    if (head.data < 10) {
      return 0;
    }
    head.data = 0;
    return 1;
  }
}
