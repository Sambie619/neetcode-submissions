class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # Example:
        # nums = [1, 5, 11, 5]
        # total sum = 22

        # If total sum is odd, we cannot split into two equal subsets
        if sum(nums) % 2:
            return False

        # dp will store all possible subset sums we can make so far
        dp = set()
        
        # 0 is always possible (choosing no elements)
        dp.add(0)
        # dp = {0}

        # We only need to find a subset with sum = total_sum / 2
        target = sum(nums) // 2
        # target = 11

        # Iterate through numbers from last to first
        for i in range(len(nums) - 1, -1, -1):
            # i goes: 3 -> 2 -> 1 -> 0
            # nums[i] values: 5 -> 11 -> 5 -> 1
            
            # Temporary set for next iteration
            nextDP = set()

            # For each existing subset sum
            for t in dp:
                
                # If adding current number reaches target, we are done
                if t + nums[i] == target:
                    return True

                # Case 1: include current number nums[i]
                nextDP.add(t + nums[i])

                # Case 2: exclude current number nums[i]
                nextDP.add(t)

            # Move to next state
            dp = nextDP

            # ---- Example states ----
            # After nums[i] = 5:
            # dp = {0, 5}
            #
            # After nums[i] = 11:
            # 0 + 11 = 11 → target found → return True
            #
            # (So loop stops early)

        # After processing all numbers, check if target sum exists
        return target in dp
