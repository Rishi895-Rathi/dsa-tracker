class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                cost[i][j] = getCost(s, i, j);
            }
        }
        int INF = 1000000000;
        int[][] dp = new int[n + 1][k + 1];
        for(int[] row : dp){
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        for(int p = 1; p <= k; p++){
            for(int i = 2 * p; i <= n; i++){
                for(int j = 2 * (p - 1); j <= i - 2; j++){
                    if(dp[j][p - 1] == INF) continue;

                    dp[i][p] = Math.min( dp[i][p] , dp[j][p - 1] + cost[j][i - 1]);
                }
            }
        }
        return dp[n][k];
    }

    public int getCost(String s, int l, int r){
        int len = r - l + 1;
        int min = Integer.MAX_VALUE;
        for(int d = 1; d < len; d++){
            if(len % d != 0) continue;
            int changes = 0;
            for(int i = 0; i < d; i++){
                int left = l + i;
                int right = l + i + ((len - 1 - i) / d) * d;
                while(left < right){
                    if(s.charAt(left) != s.charAt(right)){
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            min = Math.min(min, changes);
        }
        return min;
    }
}