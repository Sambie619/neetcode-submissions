class Solution:
    def jump(self, nums: List[int]) -> int:
        res=0
        l=r=0#window of what part in array are we in
        while r<len(nums)-1:
            farthest=0#uptill where can jump to update l,r
            for i in range(l,r+1):
                farthest=max(farthest,i+nums[i])
            l=r+1
            r=farthest#updating windows
            res+=1
        return res
        