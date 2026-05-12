class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        minheap=[]
        for x,y in points:
            dist=(x**2)+(y**2)  #dis fmla dont need of sqroot here
            minheap.append([dist,x,y])#append dist lang with coods to mh
        heapq.heapify(minheap)#to reorder into heap
        res=[]
        while k>0:#k times pop from mh
            dist,x,y=heapq.heappop(minheap)
            res.append([x,y])
            k-=1
        return res