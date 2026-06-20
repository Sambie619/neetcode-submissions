class Solution {

    // Graph: source -> destinations in sorted order
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    // LinkedList is used because we insert at the front
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph
        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            map.putIfAbsent(from, new PriorityQueue<>());

            // Store destinations in min-heap
            // so smallest airport comes first
            map.get(from).offer(to);
        }

        // Start DFS from JFK
        dfs("JFK");

        return result;
    }

    private void dfs(String airport) {

        // Get all destinations from current airport
        PriorityQueue<String> pq = map.get(airport);

        // Keep visiting destinations until none left
        while (pq != null && !pq.isEmpty()) {

            String nextAirport = pq.poll(); // smallest destination

            dfs(nextAirport);
        }

        /*
         * Important:
         * Add airport AFTER exploring all outgoing edges.
         *
         * This is postorder DFS.
         *
         * We are constructing the route backwards,
         * so insert at the front.
         */
        result.addFirst(airport);
    }
}