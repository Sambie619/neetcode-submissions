class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows and columns
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // Step 1: Binary search to find the correct row
        int top = 0;
        int bot = ROWS - 1;

        while (top <= bot) {
            int row = (top + bot) / 2;

            // If target is greater than the last element of this row,
            // then the target must be in a lower row
            // Example: target = 16, row last = 7 → go down
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            }

            // If target is smaller than the first element of this row,
            // then the target must be in an upper row
            // Example: target = 2, row first = 10 → go up
            else if (target < matrix[row][0]) {
                bot = row - 1;
            }

            // Otherwise, target must be inside this row
            else {
                break;
            }
        }

        // If no valid row was found
        if (!(top <= bot)) {
            return false;
        }

        // The row where target could exist
        int row = (top + bot) / 2;

        // Step 2: Binary search within the selected row
        int l = 0;
        int r = COLS - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            // If target is larger, search right half
            if (target > matrix[row][m]) {
                l = m + 1;
            }

            // If target is smaller, search left half
            else if (target < matrix[row][m]) {
                r = m - 1;
            }

            // Target found
            else {
                return true;
            }
        }

        // Target not found in the row
        return false;
    }
}

