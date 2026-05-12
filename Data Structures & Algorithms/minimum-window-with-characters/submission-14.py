class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l=0
        counts,countt={},{}
        for i in range(len(t)):
            countt[t[i]]=1+countt.get(t[i],0)
        have,need=0,len(countt)
        res,reslen=[-1,-1],float("infinity")
        for r in range(len(s)):
            c=s[r]
            counts[c]=1+counts.get(c,0)
            if c in countt and counts[c]==countt[c]:
                have+=1
            while have==need:
                if (r-l+1)<reslen:
                    res=[l,r]
                    reslen=(r-l+1)
                counts[s[l]]-=1
                if s[l]in countt and counts[s[l]]<countt[s[l]]:
                    have-=1
                l+=1
        l,r=res
        return s[l:r+1]if reslen<float("infinity")else ""
        