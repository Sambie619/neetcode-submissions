class Solution {
    public int minCostConnectPoints(int[][] points) {
        //in heap eles compared by weight
        Queue<int[]>minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        //boolean arr for repres each visi node or points or coods
        boolean[]visited=new boolean[points.length];
        int minCost=0;
        minHeap.offer(new int[]{0,0});//adding fst cood
        while(!minHeap.isEmpty()){
            int[]current=minHeap.poll();
            int vertex=current[0];
            int weight=current[1];
            if(visited[vertex]){
                continue;//already visited
            }
            visited[vertex]=true;//visiting ryt now 
            minCost += weight;
            //now lets explore from this vert to all others
            for(int i=0;i<points.length;i++){
                if(!visited[i]){
                    int distance=Math.abs(points[i][0]-points[vertex][0])+
                    Math.abs(points[i][1]-points[vertex][1]);//|xi - xj| + |yi - yj|
                    minHeap.offer(new int[]{i,distance});//addin next vertex to mh
                }
            }
        }
        return minCost;
    }
}
