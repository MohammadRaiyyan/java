package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

public class Merge {
  public static void main(String[] args) {
    int[] num1 = {1, 3, 5};
    int[] num2 = {1, 2, 9, 14};
    Node f = ConvertArrayToLL.convertToLL(num1);
    Node s = ConvertArrayToLL.convertToLL(num2);
    Node head = merge2(f, s);
    ConvertArrayToLL.printLLElements(head);
  }

  static Node merge2(Node f, Node s) {
    Node ans = new Node(0);
    Node tail = ans;
    while (f != null && s != null) {
      if (f.data < s.data) {
        tail.next = f;
        tail = tail.next;
        f = f.next;
      } else {
        tail.next = s;
        tail = tail.next;
        s = s.next;
      }
    }
    tail.next = f != null ? f : s;
    return ans.next;
  }

  static Node merge(Node first, Node second) {
    Node f = first;
    Node s = second;
    Node ans = new Node(0);
    Node temp = ans;
    while (f != null && s != null) {
      if (f.data < s.data) {
        temp.next = new Node(f.data);
        temp = temp.next;
        f = f.next;
      } else {
        temp.next = new Node(s.data);
        temp = temp.next;
        s = s.next;
      }
    }
    if (f != null) {
      while (f != null) {
        temp.next = new Node(f.data);
        temp = temp.next;
        f = f.next;
      }
    }
    if (s != null) {
      while (s != null) {
        temp.next = new Node(s.data);
        temp = temp.next;
        s = s.next;
      }
    }
    return ans.next;
  }
}
