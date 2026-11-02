class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mean = nums[nums.length / 2];
        int steps = 0;
        
        for(int i : nums){
            steps += Math.abs(i - mean);
        }

        return steps;
    }
}