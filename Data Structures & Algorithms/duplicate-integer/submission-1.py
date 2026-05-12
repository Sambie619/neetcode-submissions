class Solution:
    def hasDuplicate(self, nums):
        list=[]
        for num in nums:
            if num in list:
                return True
            list.append(num)
        return False

         