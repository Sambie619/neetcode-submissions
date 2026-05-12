class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k=len(nums)-k#index that we r lookin for


        def quickselect(l,r):
            pivot,p=nums[r],l
            for i in range(l,r):
                if nums[i]<=pivot:#swap it with pth index
                    nums[p],nums[i]=nums[i],nums[p]
                    p+=1#next time wanna put in next pos
            nums[p],nums[r]=nums[r],nums[p]

            if p>k:
                return quickselect(l,p-1)#look in left portion
            elif p<k:
                return quickselect(p+1,r)#look in ryt
            else:
                return nums[p]
        
        return quickselect(0,len(nums)-1)


