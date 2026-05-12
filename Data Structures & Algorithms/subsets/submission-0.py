class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        subset=[]
        def dfs(i):
            if i>=len(nums):
                res.append(subset.copy())
                return
            #decision to include nums[i](left branch)
            subset.append(nums[i])
            dfs(i+1)
            #decision not to include nums[i](ie ryt branch)
            subset.pop()
            dfs(i+1)
        dfs(0)
        return res