class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        premap={}
        for i,num in enumerate(nums):
            diff=target-num
            if diff in premap:
                return [premap[diff],i]
            premap[num]=i
            
            
        