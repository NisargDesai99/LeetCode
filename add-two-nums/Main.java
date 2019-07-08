
public class Main {

    public static void main(String[] args) {

        Node l1_0 = new Node(2);
        Node l1_1 = new Node(4);
        Node l1_2 = new Node(3);
        l1_1.next = l1_2;
        l1_0.next = l1_1;

        Node l2_0 = new Node(5);
        Node l2_1 = new Node(6);
        Node l2_2 = new Node(4);
        l2_1.next = l2_2;
        l2_0.next = l2_1;

        Node sum = add(l1_0, l2_0);
        printNodeList(sum);
    }


    public static Node add(Node l1, Node l2) {
        int carry = 0;
        int counter = 0;
        Node l1Iter = l1;
        Node l2Iter = l2;
        Node tempResult;
        Node resultIter = new Node(-1000000000);
        Node result = new Node(-1000000000);

        while (l1Iter != null && l2Iter != null) {

            if (l1Iter == null && l2Iter != null) {
                l1Iter = new Node(0);
            } else if (l2Iter == null && l1Iter != null) {
                l2Iter = new Node(0);
            }

            int currSum = l1Iter.value + l2Iter.value + carry;

            if (currSum >= 10) {
                currSum = currSum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            tempResult = new Node(currSum);

            if (counter == 0) {
                result = tempResult;
            } else {
                resultIter.next = tempResult;
            }

            resultIter = tempResult;

            l1Iter = l1Iter.next;
            l2Iter = l2Iter.next;
            counter += 1;
        }

        return result;
    }

    public static void printNodeList(Node list) {
        if (list == null) {
            return;
        }

        StringBuilder bldr = new StringBuilder();
        while (list != null) {
            bldr.append(list.value).append(", ");
            list = list.next;
        }

        bldr.delete(bldr.length() - 2, bldr.length());
        System.out.println(bldr.toString());

    }

}


class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

}
