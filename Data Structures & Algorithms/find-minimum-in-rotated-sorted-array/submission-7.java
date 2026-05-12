class Solution {
    public int findMin(int[] nums) {

        // Left pointer at start of array
        int l = 0;

        // Right pointer at end of array
        int r = nums.length - 1;

        // Initialize result with first element
        // This will store the minimum value found so far
        int res = nums[0];

        // Binary search loop
        while (l <= r) {

            /*
             * If the current subarray nums[l..r] is already sorted,
             * then the minimum element is nums[l].
             * We can update result and stop searching.
             */
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            // Find middle index
            int m = l + (r - l) / 2;

            // Update result with middle element
            res = Math.min(res, nums[m]);

            /*
             * Decide which half to search:
             *
             * If nums[m] >= nums[l], then the left half is sorted.
             * So the minimum must be in the right half.
             */
            if (nums[m] >= nums[l]) {
                l = m + 1;
            }
            /*
             * Otherwise, the right half is sorted,
             * and the minimum must be in the left half.
             */
            else {
                r = m - 1;
            }
        }

        return res;
    }
}

/*
--------------------------------
Example Walkthrough:
--------------------------------
Input: nums = [4,5,6,7,0,1,2]
Initial:
l = 0, r = 6, res = 4
Iteration 1:
nums[l] < nums[r]? → 4 < 2 ❌
m = 3 → nums[m] = 7
res = min(4, 7) = 4
nums[m] >= nums[l]? → 7 >= 4 ✅
→ Search right half → l = 4
Iteration 2:
l = 4, r = 6
nums[l] < nums[r]? → 0 < 2 ✅
res = min(4, 0) = 0
break
Return res = 0
--------------------------------
Final Answer: 0
--------------------------------
*/

