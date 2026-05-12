class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res=nums[0]
        curmax,curmin=1,1
        for num in nums:
            temp=curmax*num
            curmax=max(curmax*num,curmin*num,num)
            curmin=min(temp,curmin*num,num)
            res=max(res,curmax)
        return res