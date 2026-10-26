class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});

                    long sum = grid[i][j];
                    grid[i][j] = 0;

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int x = curr[0];
                        int y = curr[1];

                        for(int d = 0; d < 4; d++){
                            int nx = x + dir[d][0];
                            int ny = y + dir[d][1];

                            if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0){
                                sum += grid[nx][ny];
                                grid[nx][ny] = 0;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }

                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}