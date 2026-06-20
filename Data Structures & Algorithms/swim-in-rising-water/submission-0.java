class Solution {
    private static final int[][] dir = {
        {-1,0},{1,0},{0,-1},{0,1}
    };

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return time;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n ||
                    visited[nr][nc])
                    continue;

                pq.offer(new int[]{
                    nr,
                    nc,
                    Math.max(time, grid[nr][nc])
                });
            }
        }

        return -1;
    }
}