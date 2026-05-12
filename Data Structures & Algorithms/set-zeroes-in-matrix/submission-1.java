public class Solution {
    public void setZeroes(int[][] matrix) {

        // Get number of rows and columns
        int ROWS = matrix.length, COLS = matrix[0].length;

        // Flag to track if first row needs to be zeroed
        boolean rowZero = false;

        // First pass: use first row and first column as markers
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                // If current cell is zero
                if (matrix[r][c] == 0) {

                    // Mark the column in the first row
                    matrix[0][c] = 0;

                    if (r > 0) {
                        // Mark the row in the first column
                        matrix[r][0] = 0;
                    } else {
                        // If zero is in first row, remember it
                        rowZero = true;
                    }
                }
            }
        }

        // Second pass: update cells based on markers
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {

                // If row or column is marked, set cell to zero
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // If first column needs to be zeroed
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }

        // If first row needs to be zeroed
        if (rowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}

