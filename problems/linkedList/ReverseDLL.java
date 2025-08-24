package problems.linkedList;

import problems.linkedList.DLL.ConvertArrayToDLL;
import problems.linkedList.DLL.Node;

import java.util.Stack;

public class ReverseDLL {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    Node<Integer> head = ConvertArrayToDLL.convertArray(arr);
    ConvertArrayToDLL.print(reverseBetter(head));
  }

  static Node<Integer> reverseBetter(Node<Integer> head) {
    Node<Integer> current = head;
    Node<Integer> last = null;
    while (current != null) {
      last = current.back;
      current.back = current.next;
      current.next = last;
      current = current.back;
    }
    assert last != null;
    return last.back;
  }

  static Node<Integer> reverse(Node<Integer> head) {
    Stack<Integer> stack = new Stack<>();
    Node<Integer> temp = head;
    while (temp != null) {
      stack.push(temp.data);
      temp = temp.next;
    }
    temp = head;
    while (temp != null) {
      temp.data = stack.pop();
      temp = temp.next;
    }
    return head;
  }
}
