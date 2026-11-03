// class Solution {
//     public int minMoves(int[] nums) {
//         int val = 0;

//         for(int i : nums){
//             val = Math.max(val , i);
//         }
        
//         int count = 0;
//         for(int i : nums){
//             count += val - i;
//         }

//         return count;
//     }
// }

class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max*nums.length-sum;
       
    }
}