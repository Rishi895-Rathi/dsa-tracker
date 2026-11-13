// class Solution {
//     public long countNonDecreasingSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         long total = (long)n * (n + 1) / 2;
//         long invalid = 0;

//         for(int i = 0; i < n; i++){
//             int max = nums[i];
//             long ops = 0;
//             for(int j = i + 1; j < n; j++){
//                 max = Math.max(max, nums[j]);
//                 ops += max - nums[j];
//                 if(ops > k){
//                     invalid += n - j;
//                     break;
//                 }
//             }
//         }
//         return total - invalid;
//     }
// }

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for(int i = n - 1; i >= 0; i--){
            while(top >= 0 && nums[stack[top]] <= nums[i]){
                top--;
            }
            next[i] = top == -1 ? n : stack[top];
            stack[++top] = i;
        }
        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[][] jump = new int[LOG][n + 1];
        long[][] cost = new long[LOG][n + 1];
        for(int i = 0; i < n; i++){
            jump[0][i] = next[i];
            cost[0][i] = (long)nums[i] * (next[i] - i) - (prefix[next[i]] - prefix[i]);
        }
        jump[0][n] = n;
        for(int p = 1; p < LOG; p++){
            jump[p][n] = n;
            for(int i = 0; i < n; i++){
                int mid = jump[p - 1][i];

                jump[p][i] = jump[p - 1][mid];
                cost[p][i] = cost[p - 1][i] + cost[p - 1][mid];
            }
        }
        long total = (long)n * (n + 1) / 2;
        long invalid = 0;
        for(int i = 0; i < n; i++){
            int curr = i;
            long used = 0;
            for(int p = LOG - 1; p >= 0; p--){
                if(curr < n && used + cost[p][curr] <= k){
                    used += cost[p][curr];
                    curr = jump[p][curr];
                }
            }
            int right;
            if(curr == n){
                right = n - 1;
            }else{
                int low = curr;
                int high = next[curr] - 1;
                long remaining = k - used;
                while(low < high){
                    int mid = low + (high - low + 1) / 2;
                    long operations = (long)nums[curr] * (mid - curr + 1) - (prefix[mid + 1] - prefix[curr]);
                    if(operations <= remaining){
                        low = mid;
                    }else{
                        high = mid - 1;
                    }
                }
                right = low;
            }
            invalid += n - 1 - right;
        }
        return total - invalid;
    }
}