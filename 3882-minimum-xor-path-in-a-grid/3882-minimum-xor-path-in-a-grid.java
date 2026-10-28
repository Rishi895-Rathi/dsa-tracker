class Solution {
    int m;
    int n;
    int ans;
    boolean[][][] vis;

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        ans = Integer.MAX_VALUE;
        vis = new boolean[m][n][1024];

        dfs(grid, 0, 0, 0);
        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int cost){
        if(i >= m || j >= n){
            return;
        }
        cost = cost ^ grid[i][j];
        if(vis[i][j][cost]){
            return;
        }
        vis[i][j][cost] = true;
        if(i == m - 1 && j == n - 1){
            ans = Math.min(ans, cost);
            return;
        }
        dfs(grid, i + 1, j, cost);
        dfs(grid, i, j + 1, cost);
    }
}