package problems.linkedList.LL;

public class ConvertArrayToLL {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6};
    Node head = convertToLL(nums);
    // head = removeKNode(head, 5);
    // head = removeElNode(head, 1);
    // head = insertAtFirstNode(head, 0);
    // head = insertAtLast(head, 100);
    // head = insertAtKNode(head, 6, -4);
    // head = insertBeforeValueNode(head, 5, 100);
    printLLElements(head);
    // System.out.println("Length is: " + lenLL(head));
    // System.out.println(checkIfPresent(head, 9));
  }

  public static Node convertToLL(int[] nums) {
    Node head = new Node(nums[0]);
    Node tail = head;
    for (int i = 1; i < nums.length; i++) {
      Node nextNode = new Node(nums[i]);
      tail.next = nextNode;
      tail = nextNode;
    }
    return head;
  }

  public static void printLLElements(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  static int lenLL(Node head) {
    Node temp = head;
    int count = 0;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    return count;
  }

  static boolean checkIfPresent(Node head, int val) {
    Node temp = head;
    while (temp != null) {
      if (temp.data == val) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  static Node removeKNode(Node headNode, int k) {
    if (headNode == null) {
      return null;
    }
    if (k == 1) {
      headNode = headNode.next;
      return headNode;
    }
    int count = 0;
    Node temp = headNode;
    Node prev = headNode;
    while (temp.next != null) {
      count++;
      if (count == k) {
        Node current = prev.next;
        prev.next = current.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return headNode;
  }

  static Node removeElNode(Node headNode, int el) {
    if (headNode == null) {
      return null;
    }
    if (headNode.data == el) {
      headNode = headNode.next;
      return headNode;
    }
    Node temp = headNode;
    Node prev = headNode;
    while (temp.next != null) {
      if (temp.data == el) {
        Node current = prev.next;
        prev.next = current.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return headNode;
  }

  static Node insertAtFirstNode(Node hNode, int el) {
    return new Node(el, hNode);
  }

  static Node insertAtLast(Node hNode, int el) {
    if (hNode == null) {
      return new Node(el);
    }
    Node temp = hNode;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(el);
    return hNode;
  }

  static Node insertAtKNode(Node hNode, int k, int el) {
    if (hNode == null) {
      if (k == 1) {
        return new Node(el);
      }
      return null;
    }
    if (k == 1) {
      return new Node(el, hNode);
    }
    int count = 0;
    Node temp = hNode;
    while (temp.next != null) {
      count++;
      if (count == k - 1) {
        temp.next = new Node(el, temp.next);
        break;
      }
      temp = temp.next;
    }
    return hNode;
  }

  static Node insertBeforeValueNode(Node hNode, int val, int el) {
    if (hNode == null) {
      return null;
    }
    if (val == 1) {
      return new Node(el, hNode);
    }
    Node temp = hNode;
    while (temp.next != null) {
      if (temp.next.data == val) {
        temp.next = new Node(el, temp.next);
        break;
      }
      temp = temp.next;
    }
    return hNode;
  }
}
