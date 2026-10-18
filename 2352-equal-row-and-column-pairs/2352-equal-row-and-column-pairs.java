class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                int k = 0;

                while(k < grid.length && grid[i][k] == grid[k][j]){
                    k++;
                }

                if(k == grid.length)
                    count++;
            }
        }
        return count;
    }
}