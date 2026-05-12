class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        N=len(edges)
        par=[i for i in range(N+1)]#evry node is initially par of itslf
        rank=[1]*(N+1)#each node is initially single
        def find(n):
            if n!=par[n]:
                par[n]=find(par[n])#path compression change par to root node
            return par[n]
        def union(n1,n2):
            p1,p2=find(n1),find(n2)#finding th root of nodes
            if p1==p2:
                return False#no need to union
            if rank[p1]>rank[p2]:#fidn who is bigger in fam tree
                par[p2]=p1
                rank[p1]+=rank[p2]
            else:
                par[p1]=p2
                rank[p2]+=rank[p1]
            return True

        for n1,n2 in edges:
            if not union(n1,n2):#union edges together
                return [n1,n2]#this is the edge ie redundant,alrconnctd ufind findsit