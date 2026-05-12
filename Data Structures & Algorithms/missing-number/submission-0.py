class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n=len(nums)
        xorr=n
        for i in range(n):
            xorr^=i^nums[i]
        return xorr
'''Input: nums = [1,2,3]
3
Output: 0'''