class Solution {

    // 4 possible directions: up, down, left, right
    private static final int[][] dir = {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        // Min Heap
        // Stores: {row, col, max elevation seen till this cell}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        boolean[][] visited = new boolean[n][n];

        // Start from (0,0)
        // Initial time = elevation of starting cell
        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {

            // Cell with minimum required time comes out first
            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            // Already processed
            if (visited[r][c])
                continue;

            visited[r][c] = true;

            // Reached destination
            // Since PQ gives minimum time first,
            // this is the answer.
            if (r == n - 1 && c == n - 1)
                return time;

            // Explore all 4 neighbours
            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                // Outside grid
                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                // Already processed
                if (visited[nr][nc])
                    continue;

                /*
                 * To enter neighbour:
                 * Current water level must be at least
                 * max(current path time, neighbour elevation)
                 */
                int newTime = Math.max(time, grid[nr][nc]);

                pq.offer(new int[]{nr, nc, newTime});
            }
        }

        return -1; // never reached
    }
}