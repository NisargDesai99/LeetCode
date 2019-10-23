import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class Traversals {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);

        Solution solution = new Solution();

        System.out.print("Pre-order Traversal: ");
        List<Integer> preorderTraversalList = solution.preorderTraversal(root);
        printArray(preorderTraversalList);

        System.out.print("In-order Traversal: ");
        // List<Integer> inorderTraversalList = solution.inorderTraversal(root);
        // printArray(inorderTraversalList);

        System.out.print("Post-order Traversal: ");
        // List<Integer> postorderTraversalList = solution.postorderTraversal(root);
        // printArray(postorderTraversalList);

        System.out.println();
    }

    private static void printArray(List<Integer> list) {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ ");

        for (Integer i : list) {
            strBuilder.append(i).append(", ");
        }

        strBuilder.delete(strBuilder.length() - 2, strBuilder.length() - 1);
        strBuilder.append("]");

        System.out.println(strBuilder.toString());
    }

}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> list = new ArrayList<Integer>();
        // recursivePreorder(root, list);
        // return list;

        return iterativePreorder(root);
    }

    private List<Integer> iterativePreorder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> preorderStack = new Stack<TreeNode>();
        preorderStack.push(root);

        while (!preorderStack.empty()) {
            TreeNode node = preorderStack.peek();
            list.add(node.val);
            preorderStack.pop();

            if (node.right != null) {
                preorderStack.push(node.right);
            }

            if (node.left != null) {
                preorderStack.push(node.left);
            }
        }

        return list;
    }

    private void recursivePreorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        } else {
            // System.out.println(root.val);
            list.add(root.val);
            recursivePreorder(root.left, list);
            recursivePreorder(root.right, list);
        }
    }
}

