class CountSquares {

    private Map<List<Integer>, Integer> ptsCount;
    private List<List<Integer>> pts;        

    public CountSquares() {
        ptsCount=new HashMap<>();
        pts=new ArrayList<>();
    }
    
    public void add(int[] point) {
        //Convert array → List (so it can be used as a Map key)
        List<Integer>p=Arrays.asList(point[0],point[1]);
        //Update frequency map
        ptsCount.put(p,1+ptsCount.getOrDefault(p,0));
        //Store the point for iteration
        //So later we can try it as a diagonal candidate.
        pts.add(p);
    }
    
    public int count(int[] point) {
        int res=0;//total number of squares
        int px=point[0],py=point[1];//(px,py)query point
        //Loop through all stored points,
        //Each pt is treated as a possible diagonal.
        for(List<Integer>pt:pts){
            int x=pt.get(0),y=pt.get(1);//extract coods
            if(Math.abs(py-y)!=Math.abs(px-x)||x==px||y==py){
                continue;
            }
            //This enforces|px - x| == |py - y|
            //→ equal side lengths (square property)
            //x == px or y == py(only valid diagonals pass thru)
            //→ prevents lines / zero-area shapes
            //Count the remaining two corners
            res+=ptsCount.getOrDefault(Arrays.asList(x,py),0)*
            ptsCount.getOrDefault(Arrays.asList(px,y),0);
            }
            return res;

        }
    }


