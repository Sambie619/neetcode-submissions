class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // dp map stores:
        // key   = current sum
        // value = number of ways to make that sum
        // Example: sum 3 can be made in 2 different ways
        // then map will contain: 3 -> 2
        Map<Integer,Integer>dp=new HashMap<>();
        // Initially we have only one way to make sum 0(by choosing nothing yet)
        dp.put(0,1);
        // Process every number one by one
        for(int num:nums){
            // This map will store results for current step
            Map<Integer,Integer>nextDp=new HashMap<>();
            // Go through all sums formed so far
            for(Map.Entry<Integer,Integer>entry:dp.entrySet()){
                int total=entry.getKey();//curr sum
                int count=entry.getValue();//num ways to make dis sum
                // Choice 1:
                // Add current number
                // New sum becomes:
                // total + num
                // Add existing count because all previous ways
                // can now create this new sum
                nextDp.put(total+num,nextDp.getOrDefault(total + num, 0) + count);
                // Choice 2:
                // Subtract current number
                // New sum becomes:
                // total - num
                nextDp.put(
                    total - num,
                    nextDp.getOrDefault(total - num, 0) + count
                );
            }
            // Move to next step
            // dp now becomes updated results
            dp=nextDp;
        }
        //Return number of ways to form target sum
        // If target not present, return 0
        return dp.getOrDefault(target, 0);
    }
}
/*
CORE IDEA:

For every number we have ONLY 2 choices:
1. Add it
2. Subtract it

So for each existing sum,
we create 2 new sums.

Example:
nums = [1,1]

Start:
0

After first 1:
+1 => 1
-1 => -1

After second 1:
From 1:
 1+1 = 2
 1-1 = 0

From -1:
-1+1 = 0
-1-1 = -2

Final sums:
2 -> 1 way
0 -> 2 ways
-2 -> 1 way


TIME COMPLEXITY:
O(N * S)

N = number of elements
S = number of possible sums stored in map

In worst case:
O(N * 2^N)


SPACE COMPLEXITY:
O(S)

Worst case:
O(2^N)
because many different sums can be stored.
*/