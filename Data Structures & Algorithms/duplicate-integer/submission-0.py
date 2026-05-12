class Solution:
    def hasDuplicate(self, nums):
        lst=[]
        for num in nums :
            if num in lst:
                return True
            lst.append(num)
        return False
         