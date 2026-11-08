class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    boolean communicate = false;
                    for(int k = 0; k < n; k++){
                        if(k != j && grid[i][k] == 1){
                            communicate = true;
                            break;
                        }
                    }
                    for(int k = 0; k < m && !communicate; k++){
                        if(k != i && grid[k][j] == 1){
                            communicate = true;
                            break;
                        }
                    }
                    if(communicate){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}