class Solution:
    def minWindow(self, s: str, t: str) -> str:
        windows,countt={},{}
        l=0
        res,reslen=[-1,-1],float("infinity")
        for i in range(len(t)):
            countt[t[i]]=1+countt.get(t[i],0)
        have,need=0,len(countt)
        for r in range(len(s)):
            c=s[r]
            windows[c]=1+windows.get(c,0)
            if c in countt and countt[c]==windows[c]:
                have+=1
            while have==need:
                if (r-l+1)<reslen:
                    res=[l,r]
                    reslen=(r-l+1)
                windows[s[l]]-=1
                if s[l]in countt and windows[s[l]]<countt[s[l]]:
                    have-=1
                l+=1
        l,r=res
        return s[l:r+1]if reslen!=float("infinity")else ""


        


        








