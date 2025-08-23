package problems.linkedList.DLL;

class Node<T> {
  T data;
  Node<T> next;
  Node<T> back;

  public Node(T data, Node<T> next, Node<T> back) {
    this.data = data;
    this.next = next;
    this.back = back;
  }

  public Node(T data) {
    this.data = data;
    this.next = null;
    this.back = null;
  }

}