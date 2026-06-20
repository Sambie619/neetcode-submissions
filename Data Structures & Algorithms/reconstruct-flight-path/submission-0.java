class Solution {
    Map<String,PriorityQueue<String>>map=new HashMap<>();
    List<String>result=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
       for(List<String>ticket:tickets){
        if(!map.containsKey(ticket.get(0))){
            PriorityQueue<String>q=new PriorityQueue<>();
            map.put(ticket.get(0),q);
        }
        map.get(ticket.get(0)).offer(ticket.get(1));
       }
       dfs("JFK");
       return result; 
    }

    public void dfs(String s){
        PriorityQueue<String> q = map.get(s);
        while(q != null && !q.isEmpty()){
            dfs(q.poll());
        }
        result.addFirst(s);
    }
}
