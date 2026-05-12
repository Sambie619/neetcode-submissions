class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums)%2:
            return False#odd sum cant be partitioned into half
        dp=set()
        dp.add(0)#incasse if no eles in array
        target=sum(nums)//2
        for i in range(len(nums)-1,-1,-1):
            nextDP=set()#we cant update dp while trav so
            for t in dp:
                if (t+nums[i])==target:
                    return True
                nextDP.add(t+nums[i])#add to every ele in set to curr index num
                nextDP.add(t)
            dp=nextDP
        return True if target in dp else False