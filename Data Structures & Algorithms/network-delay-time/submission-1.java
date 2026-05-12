class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build the graph table
        Map<Integer,List<int[]>>graph=new HashMap<>();
        for(int[]time :times){
            int src=time[0],tar=time[1],weight=time[2];
            if(!graph.containsKey(src)){
                graph.put(src,new LinkedList<int[]>());
            }
            graph.get(src).add(new int[]{tar,weight});
        }
        //define minheap, sorted by wt smaller wt comes top
        Queue<int[]>minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        //define a hashset to keep track of visited nodes
        Set<Integer>visited=new HashSet<>();
        //add the starting node ,wt to minHeap
        minHeap.add(new int[]{k,0});//k,0 why start node has no weight to it
        int res=0;//to keeep trck of time to be in curr lvl nodes
        //perform bfs or dijkstra ......
        while(!minHeap.isEmpty()){
            int[]top=minHeap.poll();
            int src=top[0],srcWeight=top[1];//fst ele is src and scnd is wt
            if(visited.contains(src))continue;
            res=srcWeight;//basically upd res with wt from src to curr
            visited.add(src);
            //ie the node not poinin to anythin like 4
            if(!graph.containsKey(src))continue;
            for(int[]edge:graph.get(src)){
                int tar=edge[0],tarWeight=edge[1];
                //srcwt wt that curr n have,tarwt wt to go to tar node
                minHeap.add(new int[]{tar,srcWeight+tarWeight});
            }
        }
        return visited.size()==n?res:-1;

    }
}