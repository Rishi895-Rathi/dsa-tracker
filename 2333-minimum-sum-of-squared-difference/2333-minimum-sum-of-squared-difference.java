class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long k = (long) k1 + k2;
        int max = 0;

        for(int i = 0; i < n; i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        if(k >= Arrays.stream(diff).asLongStream().sum()){
            return 0;
        }

        int left = 0, right = max;

        while(left < right){
            int mid = left + (right - left) / 2;
            long needed = 0;

            for(int d : diff){
                if(d > mid){
                    needed += d - mid;
                }
            }

            if(needed <= k){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        long remaining = k;

        for(int i = 0; i < n; i++){
            if(diff[i] > left){
                remaining -= diff[i] - left;
                diff[i] = left;
            }
        }

        for(int i = 0; i < n && remaining > 0; i++){
            if(diff[i] == left && left > 0){
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;
        for(int d : diff){
            ans += (long) d * d;
        }
        return ans;
    }
}