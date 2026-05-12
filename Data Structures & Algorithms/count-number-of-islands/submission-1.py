
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        visit=set()
        islands=0
        rows,cols=len(grid),len(grid[0])
        def bfs(r,c):
            q=collections.deque()
            q.append((r,c))
            visit.add((r,c))
            while q:
                cr,cc=q.popleft()
                directions=[(0,1),(0,-1),(-1,0),(1,0)]
                for dr,dc in directions:
                    nr,nc=cr+dr,cc+dc
                    if(0 <= nr < rows and 0 <= nc < cols and 
                        grid[nr][nc] == "1" and (nr, nc) not in visit):
                        q.append((nr,nc))
                        visit.add((nr,nc))
        for r in range(rows):
            for c in range(cols):
                if ((r,c)not in visit and grid[r][c]=="1"):
                    bfs(r,c)
                    islands+=1
        return islands

            

        
        
        