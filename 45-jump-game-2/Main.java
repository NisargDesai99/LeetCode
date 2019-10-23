


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testArray = new int[] { 2,3,1,1,4 };

        System.out.println(getArrayAsString(testArray) + " -> Min Jumps: " + solution.jump(testArray));

    }

    public static String getArrayAsString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}



class Solution {

    public int jump(int[] nums) {
        int numJumps = 0;

        return numJumps;
    }

    private int getJumps(int i, int[] nums) {
        if (i == nums.length - 1) {
            return nums[i];
        }

    }

}

