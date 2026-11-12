// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int n = nums.length;
//         int max = 1;
//         for(int i = 0; i < n; i++){
//             boolean inc = true;
//             boolean dec = true;
//             for(int j = i + 1; j < n; j++){
//                 if(nums[j] > nums[j - 1] && inc){
//                     max = Math.max(max, j - i + 1);
//                     dec = false;
//                 }
//                 else if(nums[j] < nums[j - 1] && dec){
//                     max = Math.max(max, j - i + 1);
//                     inc = false;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         return max;
//     }
// }

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
       int max1=0,max2=0,i=0,j=1;
       if(nums.length==1)return 1;
       while(j<nums.length){
        if(nums[j-1]<nums[j]){
            j++;
        }else{
            i=j;
            j++;
        }
        max1=Math.max(j-i,max1);
       }
       j=1;
       i=0;
       while(j<nums.length){
        if(nums[j-1]>nums[j]){
            j++;
        }else{
            i=j;
            j++;
        }
        max2=Math.max(j-i,max2);
       }
       return Math.max(max1,max2); 
    }
}