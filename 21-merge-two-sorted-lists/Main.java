

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(-1000);
        ListNode l2 = new ListNode(-1000);

        ListNode l1Iter = l1;
        ListNode l2Iter = l2;

        int numItemsL1 = (int)(Math.random() * (20));
        int numItemsL2 = (int)(Math.random() * (20));

        // System.out.println("Items L1 = " + numItemsL1);
        // System.out.println("Items L2 = " + numItemsL2);

        int value = -1000;
        for (int i = 0; i < numItemsL1; i++) {
            value = (int)((Math.random() * ((1000 - value) + 1)) + value);
            l1Iter.next = new ListNode(value);
            l1Iter = l1Iter.next;
        }

        value = -1000;
        for (int i = 0; i < numItemsL2; i++) {
            value = (int) ((Math.random() * ((1000 - value) + 1)) + value);
            l2Iter.next = new ListNode(value);
            l2Iter = l2Iter.next;
        }

        printList(l1);
        printList(l2);

        ListNode mergedList = solution.mergeTwoLists(l1, l2);

        printList(mergedList);
    }

    public static void printList(ListNode list) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ ");

        int lengthCounter = 0;
        ListNode listIterator = list;
        while (listIterator != null) {
            strBuilder.append(listIterator.val).append(", ");
            listIterator = listIterator.next;
            lengthCounter++;
        }

        strBuilder.delete(strBuilder.length() - 2, strBuilder.length() - 1);
        strBuilder.append("] ").append("- Length = ").append(lengthCounter);

        System.out.println(strBuilder.toString());
    }

}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergedList = new ListNode(0);
        ListNode mergedListIterator = mergedList;

        while (l1 != null || l2 != null) {

            if (l1 == null && l2 != null) {
                // mergedListIterator.next = new ListNode(l2.val);
                // l2 = l2.next;
                mergedListIterator.next = l2;
                break;
            } else if (l2 == null && l1 != null) {
                // mergedListIterator.next = new ListNode(l1.val);
                // l1 = l1.next;
                mergedListIterator.next = l1;
                break;
            } else {
                if (l1.val > l2.val) {
                    // add l2.val -> add l1.val
                    mergedListIterator.next = new ListNode(l2.val);
                    l2 = l2.next;
                    // mergedListIterator = new ListNode(l2.val);
                    // mergedListIterator.next = new ListNode(l1.val);
                } else {
                    // add l1.val -> add l2.val
                    mergedListIterator.next = new ListNode(l1.val);
                    l1 = l1.next;
                    // mergedListIterator = new ListNode(l1.val);
                    // mergedListIterator.next = new ListNode(l2.val);
                }
                // else if (l1.val == l2.val) {
                // mergedListIterator.val = l1.val;
                // mergedListIterator.next = new ListNode(l2.val);
                // }

                // l1 = l1.next;
                // l2 = l2.next;

                // mergedListIterator.next = new ListNode(0);
                // mergedListIterator = mergedListIterator.next; // increment
            }

            mergedListIterator = mergedListIterator.next;
        }

        return mergedList.next;
    }
}


