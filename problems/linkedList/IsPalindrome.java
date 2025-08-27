package problems.linkedList;

import problems.linkedList.LL.ConvertArrayToLL;
import problems.linkedList.LL.Node;

import java.util.Objects;
import java.util.Stack;

public class IsPalindrome {
  public static void main(String[] args) {
    Node head = ConvertArrayToLL.convertToLL(new int[]{1, 1, 2, 1});
    System.out.println("Is Palindrome: " + isPalindrome(head));
  }

  public static boolean isPalindrome(Node head) {
    if (head.next == null) {
      return true;
    }
    // Finding Second half
    Node secondHead = findMid(head);
    if (secondHead == null) {
      return false;
    }
    // Reversing second half
    Node secondReversedHead = reverse(secondHead);
    // Comparing second half with first half
    Node first = head;
    Node second = secondReversedHead;
    while (second != null) {
      if (Objects.equals(second.data, first.data)) {
        first = first.next;
        second = second.next;
      } else {
        return false;
      }
    }
    return true;
    // Stack<Integer> stack = new Stack<>();
    // Node temp = head;
    // while (temp != null) {
    //     stack.push(temp.val);
    //     temp = temp.next;
    // }
    // temp = head;
    // while (temp != null) {
    //     if (Objects.equals(temp.val, stack.pop())) {
    //         temp = temp.next;
    //     } else {
    //         return false;
    //     }
    // }
    // return true;
  }

  public static Node findMid(Node head) {
    Node f = head;
    Node s = head;
    while (f.next != null && f.next.next != null) {
      System.out.println(f.data);
      f = f.next.next;
      s = s.next;
    }
    assert s != null;
    return s.next;
  }

  public static Node reverse(Node head) {
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

  static boolean checkBrute(Node head) {
    Stack<Integer> stack = new Stack<>();
    Node temp = head;
    while (temp != null) {
      stack.push(temp.data);
      temp = temp.next;
    }
    temp = head;
    while (temp != null) {
      if (Objects.equals(temp.data, stack.pop())) {
        temp = temp.next;
      } else {
        return false;
      }
    }
    return true;
  }
}
