class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for(int i = 0; i < n / 2; i++){
            int a = Math.min(nums[i], nums[n - i - 1]);
            int b = Math.max(nums[i], nums[n - i - 1]);

            diff[2] += 2;

            diff[a + 1]--;
            diff[b + limit + 1]++;

            diff[a + b]--;
            diff[a + b + 1]++;
        }
        int ans = Integer.MAX_VALUE;
        int moves = 0;

        for(int target = 2; target <= 2 * limit; target++){
            moves += diff[target];
            ans = Math.min(ans, moves);
        }

        return ans;
    }
}