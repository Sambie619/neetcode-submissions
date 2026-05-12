class Solution {
    public int search(int[] nums, int target) {
        // Left pointer
        int l = 0;
        // Right pointer
        int r = nums.length - 1;
        // Binary search loop
        while (l <= r) {
            // Middle index
            int mid = (l + r) / 2;
            // If target is found, return its index
            if (nums[mid] == target) {
                return mid;
            }
            /*
             * Check which half is sorted
             */
            // Case 1: Left half is sorted
            if (nums[l] <= nums[mid]) {
                /*
                 * If target is NOT in the sorted left half,
                 * then search in the right half
                 */
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                }
                /*
                 * Otherwise, target lies in the left half
                 */
                else {
                    r = mid - 1;
                }
            }
            // Case 2: Right half is sorted
            else {
                /*
                 * If target is NOT in the sorted right half,
                 * then search in the left half
                 */
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                }
                /*
                 * Otherwise, target lies in the right half
                 */
                else {
                    l = mid + 1;
                }
            }
        }
        // Target not found
        return -1;
    }
}
/*
------------------------------------------------
Example Walkthrough:
------------------------------------------------
nums = [4,5,6,7,0,1,2]
target = 0
Initial:
l = 0, r = 6
Iteration 1:
mid = 3 → nums[mid] = 7
Left half sorted? → nums[l] <= nums[mid] → 4 <= 7 ✅
Is target in left half? → 0 < 4 ❌
→ Search right half → l = 4
Iteration 2:
l = 4, r = 6
mid = 5 → nums[mid] = 1
Left half sorted? → nums[l] <= nums[mid] → 0 <= 1 ✅
Is target in left half? → 0 >= 0 and 0 <= 1 ✅
→ Search left → r = 4
Iteration 3:
l = 4, r = 4
mid = 4 → nums[mid] = 0
Target found → return index 4
------------------------------------------------
Final Answer: 4
------------------------------------------------
*/
