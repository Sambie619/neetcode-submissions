class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count={}
        for n in nums:
            count[n]=1+count.get(n,0)
        frequency=[[]for i in range(len(nums)+1)]
        for num,coun in count.items():
            frequency[coun].append(num)
        res=[]
        for i in range(len(frequency)-1,-1,-1):
            for ele in frequency[i]:
                res.append(ele)
                k-=1
                if k==0:
                    return res
