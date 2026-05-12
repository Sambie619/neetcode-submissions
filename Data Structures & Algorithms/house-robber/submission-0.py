class Solution:
    def rob(self, nums: List[int]) -> int:
        '''Input: nums = [2,9,8,3,6]/Output: 16
        nums[0] + nums[2] + nums[4] = 2 + 8 + 6 = 16'''
        rob1,rob2=0,0
        for n in nums:
            temp=max(n + rob1,rob2)
            rob1=rob2
            rob2=temp
        return rob2
