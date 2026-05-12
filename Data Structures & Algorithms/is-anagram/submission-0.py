class Solution:
    def isAnagram(self,s,t)->bool:
        counts={}
        countt={}
        for  c in s:
            if c in counts:
                counts[c]+=1
            else:
                counts[c]=1
        for c in t:
            if c in countt:
                countt[c]+=1
            else:
                countt[c]=1
        return counts==countt
        