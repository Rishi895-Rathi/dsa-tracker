class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        for(int i = 0; i < n; i++){
            boolean inc = true;
            boolean dec = true;
            for(int j = i + 1; j < n; j++){
                if(nums[j] > nums[j - 1] && inc){
                    max = Math.max(max, j - i + 1);
                    dec = false;
                }
                else if(nums[j] < nums[j - 1] && dec){
                    max = Math.max(max, j - i + 1);
                    inc = false;
                }
                else{
                    break;
                }
            }
        }
        return max;
    }
}