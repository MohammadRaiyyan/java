package problems.linkedList.DLL;

public class ConvertArrayToDLL {
  public static void main(String[] args) {
    int[] arr = {1, 2, 10, 3, 4, 5, 6};
    Node<Integer> head = convertArray(arr);
    // head = removeHeadNode(head);
//    head = removeTailNode(head);
    head = removeKthNode(head, 6);
    print(head);
  }

  public static Node<Integer> convertArray(int[] arr) {
    Node<Integer> head = new Node<>(arr[0]);
    Node<Integer> prev = head;
    for (int i = 1; i < arr.length; i++) {
      Node<Integer> newNode = new Node<>(arr[i], null, prev);
      prev.next = newNode;
      prev = newNode;
    }
    return head;
  }

  static Node<Integer> removeKthNode(Node<Integer> head, int k) {
    if (head == null) return null;
    if (k == 1) {
      if (head.next != null) {
        head = head.next;
        head.back = null;
        return head;
      }
      return null;
    }
    Node<Integer> temp = head;
    int count = 1;
    while (temp.next != null && count < k) {
      count++;
      temp = temp.next;
    }
    Node<Integer> prev = temp.back;
    Node<Integer> next = temp.next;
    if (prev != null) prev.next = next;
    if (next != null) next.back = prev;
    temp.back = null;
    temp.next = null;
    return head;
  }

  public static <T> void print(Node<T> head) {
    Node<T> temp = head;
    while (temp != null) {
      System.out.println(temp.data + " ");
      temp = temp.next;
    }
  }

  static Node<Integer> removeTailNode(Node<Integer> head) {
    if (head == null || head.next == null) {
      return null;
    }
    Node<Integer> temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    Node<Integer> tail = temp.next;
    temp.next = null;
    tail.back = null;
    return head;
  }

  static Node<Integer> removeHeadNode(Node<Integer> head) {
    if (head == null || head.next == null) {
      return null;
    }
    Node<Integer> prev = head;
    head = prev.next;
    head.back = null;
    prev.next = null;
    return head;

  }
}
