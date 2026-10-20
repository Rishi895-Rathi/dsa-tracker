import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        boolean alreadySorted = true;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                alreadySorted = false;
                break;
            }
        }

        for(int k = 1; k <= n; k++){
            if(n % k != 0) continue;

            if(alreadySorted){
                ans += k;
                continue;
            }

            if(k == 1) continue;

            boolean valid = true;

            for(int start = 0; start < n; start += k){
                int descent = -1;
                int count = 0;

                for(int i = start + 1; i < start + k; i++){
                    if(nums[i] < nums[i - 1]){
                        descent = i;
                        count++;
                    }
                }

                if(count > 1){
                    valid = false;
                    break;
                }

                if(descent == -1) descent = start;

                for(int i = 0; i < k; i++){
                    if(nums[start + (descent - start + i) % k] != sorted[start + i]){
                        valid = false;
                        break;
                    }
                }

                if(!valid) break;
            }

            if(valid) ans += k;
        }

        return ans;
    }
}