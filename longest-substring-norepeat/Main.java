public class Main {
    public static void main(String[] args) {
        Solution soln = new Solution();

        int maxLength = soln.lengthOfLongestSubstring("pwwkew");
        System.out.println(maxLength);

    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char charAtJ = s.charAt(j);
            int indexCharAtJ = index[charAtJ];
            i = Math.max(index[charAtJ], i);
            ans = Math.max(ans, j - i + 1);
            index[charAtJ] = j + 1;
        }
        return ans;
    }
}