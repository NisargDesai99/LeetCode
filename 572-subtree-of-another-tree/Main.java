

public class Main {

    public static void main(String[] args) {

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.left.left = new TreeNode(10);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        t.left.left.left = new TreeNode(10);

        Solution solution = new Solution();
        System.out.println("Tree s == Tree t ? -> " + solution.isSubtree(s, t));

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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }

        if (s == null) {
            return false;
        }

        if (checkIfIdentical(s, t)) {
            return true;
        }

        // System.out.println("About to recurse left: isSubtree(" + ((s.left == null) ? "null" : s.left.val) + ", " + ((t == null) ? "null" : t.val) + ")");
        // boolean foundLeft = isSubtree(s.left, t);
        // System.out.println("About to recurse right: isSubtree(" + ((s.left == null) ? "null" : s.left.val) + ", " + ((t == null) ? "null" : t.val) + ")");
        // boolean foundRight = isSubtree(s.right, t);
        // return foundLeft || foundRight;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean checkIfIdentical(TreeNode s, TreeNode t) {

        // System.out.println("s = " + ((s == null) ? "null" : s.val) + " t = " + ((t == null) ? "null" : t.val));

        if (s == null && t == null) {
            return true;
        }
        
        // We have already check for the case that both are null. This if statement is to check if one of them is null.
        if (s == null || t == null) {
            return false;
        }
        
        // boolean equal = s.val == t.val;
        // System.out.println("s == t = " + equal);
        // boolean leftEqual = checkIfIdentical(s.left, t.left);
        // System.out.println("s.left == t.left = " + leftEqual);
        // boolean rightEqual = checkIfIdentical(s.right, t.right);
        // System.out.println("s.right == t.right = " + rightEqual);
        // return equal && leftEqual && rightEqual;

        return (s.val == t.val && checkIfIdentical(s.left, t.left) && checkIfIdentical(s.right, t.right));
    }

}
