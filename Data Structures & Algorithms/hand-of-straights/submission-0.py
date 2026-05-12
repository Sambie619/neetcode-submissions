class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand)%groupSize:
            return False
        count={}
        for n in hand:
            count[n]=1+count.get(n,0)
        minheap=list(count.keys())#for knowing min val each time
        heapq.heapify(minheap)
        while minheap:
            first=minheap[0]#get min val
            for i in range(first,first+groupSize):
                if i not in count:
                    return False#val you loo for aint avai
                count[i]-=1
                if count[i]==0:
                    if i!=minheap[0]:
                        return False#cant pop from mh thats not min,
                    heapq.heappop(minheap)#coz create a hol in next grp 
        return True
        