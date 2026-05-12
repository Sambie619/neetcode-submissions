class CountSquares:

    def __init__(self):
        self.ptscount=defaultdict(int)
        self.pts=[]

    def add(self, point: List[int]) -> None:
        self.ptscount[tuple(point)]+=1
        self.pts.append(point)

    def count(self, point: List[int]) -> int:
        res=0
        px,py=point
        for x,y in self.pts:
            if(abs(py-y)!=abs(px-x)) or x==px or y==py:
                continue
            res+=self.ptscount[(x,py)]*self.ptscount[(px,y)]
        return res
        
