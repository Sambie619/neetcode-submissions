class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.minheap,self.k=nums,k
        heapq.heapify(self.minheap)#Now the smallest element is always at the top (
        while len(self.minheap)>self.k:
            heapq.heappop(self.minheap)
            #if more than k ele we pop so only k largestll be there
            #and first will be the kth largest
    def add(self, val: int) -> int:
        heapq.heappush(self.minheap,val)
        if len(self.minheap)>self.k:
            heapq.heappop(self.minheap)
        return self.minheap[0]
    #Keep only k largest elements in a min-heap. Root = kth largest.
        
