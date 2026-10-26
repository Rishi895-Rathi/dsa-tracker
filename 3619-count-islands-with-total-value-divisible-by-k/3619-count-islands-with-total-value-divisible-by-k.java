// class Solution {
//     public int countIslands(int[][] grid, int k) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] > 0){
//                     Queue<int[]> q = new LinkedList<>();
//                     q.offer(new int[]{i,j});

//                     long sum = grid[i][j];
//                     grid[i][j] = 0;

//                     while(!q.isEmpty()){
//                         int[] curr = q.poll();
//                         int x = curr[0];
//                         int y = curr[1];

//                         for(int d = 0; d < 4; d++){
//                             int nx = x + dir[d][0];
//                             int ny = y + dir[d][1];

//                             if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0){
//                                 sum += grid[nx][ny];
//                                 grid[nx][ny] = 0;
//                                 q.offer(new int[]{nx,ny});
//                             }
//                         }
//                     }

//                     if(sum % k == 0){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

//Approach two --- after submission i findout this one 

class Solution {

    long sum=0;
    void dfs(int[][] grid, int row, int col)
    {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0)
        return;

        sum+=grid[row][col];
        grid[row][col]=0;
        
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);;
    }
    public int countIslands(int[][] grid, int k) {
        int n=0;
        for(int row=0; row<grid.length; row++)
        {
            for(int col=0; col<grid[0].length; col++)
            {
                if(grid[row][col]!=0)
                {
                    dfs(grid,row,col);
                    if(sum%k==0)
                    n++;
                    sum=0;
                }
            }
        }
        return n;
    }
}