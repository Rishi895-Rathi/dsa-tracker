class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        int left = 0, right = nums.length - 1;
        int first = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){
                if(nums[mid] == target) first = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        if(first == -1) return res;

        left = first;
        right = nums.length - 1;
        int last = first;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] <= target){
                if(nums[mid] == target) last = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        for(int i = first; i <= last; i++){
            res.add(i);
        }

        return res;
    }
}