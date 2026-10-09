class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        System.gc();
        return nums[0];
    }
}