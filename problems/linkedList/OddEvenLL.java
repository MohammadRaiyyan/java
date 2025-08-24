package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLL {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    Node head = ConvertArrayToLL.convertToLL(arr);
    ConvertArrayToLL.printLLElements(reArrange3(head));
  }

  static Node reArrange3(Node head) {
    if (head == null || head.next == null) return head;
    Node odd = head;
    Node even = head.next;
    Node evenStart = head.next;
    while (even != null && even.next != null) {
      odd.next = odd.next.next;
      even.next = even.next.next;
      odd = odd.next;
      even = even.next;
    }
    odd.next = evenStart;
    return head;
  }

  static Node reArrange2(Node head) {
    if (head == null) return null;
    List<Integer> list = new ArrayList<>();
    Node temp = head;
    while (temp != null && temp.next != null) {
      list.add(temp.data);
      temp = temp.next.next;
    }
    if (temp != null) {
      list.add(temp.data);
    }
    temp = head.next;
    while (temp != null) {
      list.add(temp.data);
      temp = temp.next.next;
    }
    temp = head;
    int count = 0;
    while (temp != null) {
      temp.data = list.get(count);
      count++;
      temp = temp.next;
    }
    return head;
  }

  static Node reArrange(Node head) {
    Node dummyOdd = new Node(0);
    Node dummyEven = new Node(0);
    Node oddTail = dummyOdd;
    Node evenTail = dummyEven;
    int count = 1;
    Node curr = head;
    while (curr != null) {
      Node newNode = new Node(curr.data);
      // Odd
      if (count % 2 != 0) {
        oddTail.next = newNode;
        oddTail = newNode;
      } else {
        evenTail.next = newNode;
        evenTail = newNode;
      }
      curr = curr.next;
      count++;
    }
    oddTail.next = dummyEven.next;
    return dummyOdd.next;
  }

}
