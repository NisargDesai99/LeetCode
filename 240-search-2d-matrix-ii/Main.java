
public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        // int[][] matrix2 = new int[][] {
        //     {1,   4,  7, 11},
        //     {2,   5,  8, 12},
        //     {3,   6,  9, 16},
        //     {10, 13, 14, 17},
        //     {18, 21, 23, 26}
        // };

        // System.out.println("row len = " + matrix2.length);
        // System.out.println("col len = " + matrix2[0].length);

        // System.out.println((5/2));

        Solution solution = new Solution();
        int target = 13;
        System.out.println("Searching for " + target + ": " + solution.omplusnSearchMatrix(matrix, target));
        // System.out.println("Searching for " + target + ": " + solution.recursiveBinarySearchMatrix(matrix, target, 0, 0, matrix.length, matrix[0].length));
    }


}

class Solution {
    public boolean omnSearchMatrix(int[][] matrix, int target) {
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean omplusnSearchMatrix(int[][] matrix, int target) {
        
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return false;
        }

        int colLen = matrix[0].length;

        int row = 0;
        int col = colLen - 1;

        while (row < rowLen && col >= 0) {
            int currValue = matrix[row][col];
            if (target > currValue) {
                row++;
            } else if (target < currValue) {
                col--;
            } else {
                return true;
            }
        }
        
        return false;
    }

}




