package problems.linkedList.LL;

public class Node {
  public Integer data;
  public Node next;

  public Node(Integer data, Node next) {
    this.data = data;
    this.next = next;
  }

  public Node(Integer data) {
    this.data = data;
    this.next = null;
  }
}
