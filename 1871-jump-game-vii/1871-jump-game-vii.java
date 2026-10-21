class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;

        int count = 0;

        for(int i = 1; i < n; i++){
            int add = i - minJump;
            int remove = i - maxJump - 1;

            if(add >= 0 && dp[add]) count++;
            if(remove >= 0 && dp[remove]) count--;

            if(s.charAt(i) == '0' && count > 0){
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}