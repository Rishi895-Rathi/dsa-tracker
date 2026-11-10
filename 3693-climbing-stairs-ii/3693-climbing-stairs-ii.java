class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(0, n, costs);
    }

    public int dfs(int i, int n, int[] costs){
        if(i == n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int j = i + 1; j <= Math.min(i + 3, n); j++){
            int cost = costs[j - 1] + (j - i) * (j - i);
            ans = Math.min(ans, cost + dfs(j, n, costs));
        }
        return dp[i] = ans;
    }
}