package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class AddTwoNumber {
  public static void main(String[] args) {
    int[] num1 = {2, 4, 3};
    int[] num2 = {5, 6, 4};
    Node head1 = ConvertArrayToLL.convertToLL(num1);
    Node head2 = ConvertArrayToLL.convertToLL(num2);
    Node sumNode = add(head1, head2);
    ConvertArrayToLL.printLLElements(sumNode);
  }

  static Node add(Node head1, Node head2) {
    Node dummyNode = new Node(0);
    Node curr = dummyNode;
    Node temp1 = head1;
    Node temp2 = head2;
    int carry = 0;
    while (temp1 != null || temp2 != null) {
      int sum = carry;
      if (temp1 != null) sum = sum + temp1.data;
      if (temp2 != null) sum = sum + temp2.data;
      Node newNode = new Node(sum % 10);
      carry = sum / 10;
      curr.next = newNode;
      curr = curr.next;
      if (temp1 != null) temp1 = temp1.next;
      if (temp2 != null) temp2 = temp2.next;
    }
    if (carry > 0) {
      curr.next = new Node(carry);
    }
    return dummyNode.next;
  }
}
