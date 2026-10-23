class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        boolean sorted = true;

        for(int i = 0; i < n; i++){
            if(nums[i] != i){
                sorted = false;
                k = (k == -1) ? nums[i] : k & nums[i];
            }
        }

        if(sorted) return 0;

        return k;
    }
}