class Solution:

    def encode(self, strs: List[str]) -> str:
        str1=""
        for s in strs:
            str1+=str(len(s))+"#"+s
        return str1

    def decode(self, s: str) -> List[str]:
        str2=[]
        i=0
        while i<len(s):
            j=i
            while s[j]!="#":
                j+=1
            length=int(s[i:j])
            i=j+1
            
            j=i+length
            str2.append(s[i:j])
            i=j
        return str2

