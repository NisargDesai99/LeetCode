

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] testArray = new int[] { 2,3,1,1,4 };
        int[] testArray1 = new int[] { 3,2,1,0,4 };

        System.out.println(getArrayAsString(testArray) + ": " + solution.canJump(testArray));
        System.out.println(getArrayAsString(testArray1) + ": " + solution.canJump(testArray1));

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

    public static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());
    }

}



class Solution {
    public boolean canJump(int[] nums) {
        int workingPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= workingPos) {
                workingPos = i;
            }
        }

        return workingPos == 0;
    }
}