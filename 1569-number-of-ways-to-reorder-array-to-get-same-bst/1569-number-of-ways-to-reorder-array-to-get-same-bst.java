class Solution {
    long mod = 1000000007;
    long[][] dp;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        dp = new long[n + 1][n + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
            }
        }

        return (int)((ways(nums) - 1 + mod) % mod);
    }

    long ways(int[] nums){
        int n = nums.length;

        if(n <= 2) return 1;

        int root = nums[0];
        int[] left = new int[n];
        int[] right = new int[n];
        int l = 0, r = 0;

        for(int i = 1; i < n; i++){
            if(nums[i] < root){
                left[l++] = nums[i];
            }else{
                right[r++] = nums[i];
            }
        }

        int[] leftArr = new int[l];
        int[] rightArr = new int[r];

        System.arraycopy(left, 0, leftArr, 0, l);
        System.arraycopy(right, 0, rightArr, 0, r);

        // Left aur right subtree ke valid reorderings calculate karo
        long leftWays = ways(leftArr);
        long rightWays = ways(rightArr);

        // Left ke l elements ke liye l+r positions mein se l positions choose karo
        long combinations = dp[l + r][l];

        // Total ways = combinations * leftWays * rightWays
        return combinations * leftWays % mod * rightWays % mod;
    }
}