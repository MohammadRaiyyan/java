package problems.linkedList;

import problems.linkedList.LL.Node;

public class DetectCycle2 {
  public Node detectCycle(Node head) {
    // optimal
    if (head == null || head.next == null) return null;
    Node slow = head, fast = head;
    // Detect cycle
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        // Reset one pointer to head
        Node start = head;
        while (start != slow) {
          start = start.next;
          slow = slow.next;
        }
        return start; // cycle start
      }
    }
    return null;
    // better
    // if(head == null || head.next == null) return null;
    // Node f = head;
    // Node s = head;
    // int length = 0;
    // while(f != null && f.next != null){
    //     f = f.next.next;
    //     s = s.next;
    //     if(f == s){
    //         length = lengthCycle(s);
    //         break;
    //     }
    // }
    // if(length == 0 ) return null;
    // // Find the first node
    // Node first = head;
    // Node second = head;
    // while(length > 0){
    //     second = second.next;
    //     length--;
    // }
    // while(first != second){
    //     first = first.next;
    //     second = second.next;
    // }
    // return first;
  }
  // public int lengthCycle(Node head) {
  //     Node f = head;
  //     Node s = head;
  //     int length = 0;
  //     while(f != null && f.next != null){
  //         f = f.next.next;
  //         s = s.next;
  //         if(f == s){
  //             Node temp = s;
  //             do{
  //                 temp = temp.next;
  //                 length++;
  //             } while(temp != s);
  //             return length;
  //         }
  //     }
  //     return 0;
  // }
}
