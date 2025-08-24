package problems.linkedList.DLL;

public class Node<T> {
  public T data;
  public Node<T> next;
  public Node<T> back;

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