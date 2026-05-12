class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        par=[i for i in range(n)]
        rank=[1]*n
        def find(x):
            while x!=par[x]:
                par[x]=par[par[x]]
                x=par[x]
            return x
        def union(x,y):
            p1,p2=find(x),find(y)
            if p1==p2:
                return 0
            if rank[p1]<rank[p2]:
                par[p1]=p2
                rank[p2]+=rank[p1]
            else:
                par[p2]=p1
                rank[p1]+=rank[p2]
            return 1
        for a,b in edges:
            n-=union(a,b)
        return n



            