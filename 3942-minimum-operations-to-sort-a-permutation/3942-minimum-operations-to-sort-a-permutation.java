class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc = 0, dsc = 0;

        for(int i = 1; i < n; i++){
            // Count ascending consecutive elements (with circular wrap-around)
            // Formula: nums[i] == (nums[i-1] + 1) % n
            asc += (nums[i] == (nums[i-1] + 1) % n) ? 1 : 0;

            // Count descending consecutive elements (with circular wrap-around)
            // Formula: nums[i-1] == (nums[i] + 1) % n
            dsc += (nums[i-1] == (nums[i] + 1) % n) ? 1 : 0;
        }

        // Already sorted in ascending order starting from 0
        if(asc == n-1 && nums[0] == 0){
            return 0;
        }

        if(asc == n-1){
            // Left rotation required to bring 0 to the first position
            int leftRo = n - nums[0];

            // Right rotation formula used in your approach
            int rightRo = 1 + (nums[n-1] + 1) + 1;

            return Math.min(leftRo, rightRo);
        }

        if(dsc == n-1){
            // Left rotation formula used in your approach
            int leftRo = n - nums[n-1] + 1;

            // Right rotation formula used in your approach
            int rightRo = (nums[0] + 1) % n + 1;

            return Math.min(rightRo, leftRo);
        }

        // Neither ascending nor descending consecutive order
        return -1;
    }
}