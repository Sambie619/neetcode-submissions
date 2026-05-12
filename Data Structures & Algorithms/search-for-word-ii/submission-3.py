class TrieNode:
    def __init__(self):
        self.children={}
        self.endword=False
    def add(self,word):
        node=self
        for w in word:
            if w not in node.children:
                node.children[w]=TrieNode()
            node=node.children[w]
        node.endword=True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root=TrieNode()
        for w in words:
            root.add(w)
        rows,cols=len(board),len(board[0])
        visit,res=set(),set()
        def dfs(r,c,root,word):
            if(min(r,c)<0 or r>=rows or c>= cols or board[r][c] not in root.children or (r,c)in visit):
                return
            visit.add((r,c))
            word+=board[r][c]
            root=root.children[board[r][c]]
            if root.endword:
                res.add(word)
            dfs(r+1,c,root,word)
            dfs(r-1,c,root,word)
            dfs(r,c+1,root,word)
            dfs(r,c-1,root,word)
            visit.remove((r,c))
        for r in range(rows):
            for c in range(cols):
                dfs(r,c,root,"")
        return list(res)

        
        