// class Solution {
//     public int countServers(int[][] grid) {

//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == 1){
//                     boolean communicate = false;
//                     for(int k = 0; k < n; k++){
//                         if(k != j && grid[i][k] == 1){
//                             communicate = true;
//                             break;
//                         }
//                     }
//                     for(int k = 0; k < m && !communicate; k++){
//                         if(k != i && grid[k][j] == 1){
//                             communicate = true;
//                             break;
//                         }
//                     }
//                     if(communicate){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

// approach two – dfs

class Solution {
    int m,n;
    int count;
    public int countServers(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int size = dfs(grid,i,j,vis);
                    if(size > 1){
                        count += size;
                    }
                }
            }
        }
        return count;
    }

    public int dfs(int[][] grid,int i,int j,boolean[][] vis){
        vis[i][j] = true;
        int size = 1;
        for(int k = 0; k < n; k++){
            if(grid[i][k] == 1 && !vis[i][k]){
                size += dfs(grid,i,k,vis);
            }
        }
        for(int k = 0; k < m; k++){
            if(grid[k][j] == 1 && !vis[k][j]){
                size += dfs(grid,k,j,vis);
            }
        }

        return size;
    }
}