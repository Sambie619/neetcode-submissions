class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas)<sum(cost):
            return -1  # given
        total=0#for knowing gas sum
        res=0#to know starting point
        for i in range(len(gas)):
            total+=(gas[i]-cost[i])
            if total<0:
                #if dips bel 0 this pos not gonna work
                total=0#rest gas sum
                res=i+1#since curr starting pos didnt work
        return res
        