class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        for(int i = 1; i <= nums.length; i++){
            int temp = nums[i - 1];
            if(nums.length % i == 0){
                temp = temp*temp;
                sum += temp;
            }
        }
        return sum;
    }
}