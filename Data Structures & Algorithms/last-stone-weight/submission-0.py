class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones=[-s for s in stones] #Python’s heapq is a min-heap
        heapq.heapify(stones)#Converts the list into a valid heap structure
        while len(stones)>1:#Continue until there’s at most one stone left
            first=heapq.heappop(stones)#Pop the two heaviest stones
            second=heapq.heappop(stones)
            if second>first:#wts are uneven -first weigh more..
                heapq.heappush(stones,first-second)#smaller gets destroyed
        stones.append(0)#in-case all stones got destroyed to ret safely
        return abs(stones[0])


        