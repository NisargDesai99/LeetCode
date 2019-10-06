/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

class Solution {
    public Node copyRandomList(Node head) {

        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;

            Node temp = new Node();
            temp.val = current.val;
            current.next = temp;
            temp.next = next;

            current = next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node copy = null;
        Node headForCopy = new Node();
        headForCopy.val = 0;
        Node tailForCopy = headForCopy;

        while (current != null) {
            next = current.next.next;
            copy = current.next;

            tailForCopy.next = copy;
            tailForCopy = copy; // increment

            current.next = next;
            current = next; // increment
        }

        return headForCopy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution soln = new Solution();

        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null, null), null), null), null), null);
        soln.copyRandomList(head);
    }
}

