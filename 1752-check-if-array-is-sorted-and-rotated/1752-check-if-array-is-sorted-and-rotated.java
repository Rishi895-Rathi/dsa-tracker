// class Solution {
//     public boolean check(int[] nums) {
//         int[] b=Arrays.copyOf(nums,nums.length);
//         Arrays.sort(b);
//         int count=0;

//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i] > nums[i+1]){
//                 count=i+1;
//                 break;
//             }
//         }

//         for(int i=0;i<b.length;i++){
//             if(b[i] == nums[(i+count)%nums.length]){
//                 continue;
//             }
//             else{
//                 return false;
//             }
//         }

//         return true;
//     }
// }

// APPROACH  two 

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i+1)%n]){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}