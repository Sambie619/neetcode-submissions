
public class Solution {

    public int largestRectangleArea(int[] heights) {

        // Example:
        // heights = [2, 1, 5, 6, 2, 3]
        // index      0  1  2  3  4  5

        int n = heights.length;

        // leftMost[i]  = index of nearest smaller bar on the LEFT of i
        // rightMost[i] = index of nearest smaller bar on the RIGHT of i
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];

        // Stack will store indices of bars
        // It will be MONOTONIC INCREASING by height
        Stack<Integer> stack = new Stack<>();

        // --------------------------------------------------
        // STEP 1: Find nearest smaller bar on the LEFT
        // --------------------------------------------------
        for (int i = 0; i < n; i++) {

            // Default: assume no smaller bar exists on the left
            leftMost[i] = -1;

            // While stack is not empty AND
            // height of bar at stack top >= current bar
            // pop because that bar cannot be the "nearest smaller"
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // If stack is not empty now,
            // the top is the nearest smaller bar on the left
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }

            // Push current index onto stack
            stack.push(i);

            /*
              Example walkthrough:

              i = 2, heights[i] = 5
              stack contains [1] where heights[1] = 1
              1 < 5 → no pop
              leftMost[2] = 1
              stack becomes [1, 2]
            */
        }

        // Clear stack before reusing
        stack.clear();

        // --------------------------------------------------
        // STEP 2: Find nearest smaller bar on the RIGHT
        // --------------------------------------------------
        for (int i = n - 1; i >= 0; i--) {

            // Default: assume no smaller bar exists on the right
            rightMost[i] = n;

            // Same logic as before, but moving right → left
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // If stack is not empty,
            // top is nearest smaller bar on the right
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }

            // Push current index
            stack.push(i);

            /*
              Example walkthrough:

              i = 2, heights[i] = 5
              stack contains [4] where heights[4] = 2
              2 < 5 → no pop
              rightMost[2] = 4
            */
        }

        // --------------------------------------------------
        // STEP 3: Compute maximum rectangle area
        // --------------------------------------------------
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Move inside the smaller bars
            // because leftMost/rightMost point to SMALLER bars
            int leftBoundary = leftMost[i] + 1;
            int rightBoundary = rightMost[i] - 1;

            // Width where current bar can extend
            int width = rightBoundary - leftBoundary + 1;

            // Area using heights[i] as the minimum height
            int area = heights[i] * width;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            /*
              Example for i = 2 (height = 5):

              leftMost[2]  = 1 → leftBoundary  = 2
              rightMost[2] = 4 → rightBoundary = 3

              width = 3 - 2 + 1 = 2
              area  = 5 * 2 = 10
            */
        }

        // Return the largest rectangle area found
        return maxArea;
    }
}

