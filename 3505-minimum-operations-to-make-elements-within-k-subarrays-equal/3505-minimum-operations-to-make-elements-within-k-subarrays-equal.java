class Solution {

    class DualSet {
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();

        int lowSize = 0;
        int highSize = 0;

        long lowSum = 0;
        long highSum = 0;

        void add(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void remove(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if(count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void add(int val) {
            if(lower.isEmpty() || val <= lower.lastKey()) {
                add(lower, val);
                lowSize++;
                lowSum += val;
            } else {
                add(upper, val);
                highSize++;
                highSum += val;
            }

            balance();
        }

        void remove(int val) {
            if(lower.containsKey(val)) {
                remove(lower, val);
                lowSize--;
                lowSum -= val;
            } else {
                remove(upper, val);
                highSize--;
                highSum -= val;
            }

            balance();
        }

        void balance() {
            while(lowSize < highSize) {
                int val = upper.firstKey();

                remove(upper, val);
                highSize--;
                highSum -= val;

                add(lower, val);
                lowSize++;
                lowSum += val;
            }

            while(lowSize > highSize + 1) {
                int val = lower.lastKey();

                remove(lower, val);
                lowSize--;
                lowSum -= val;

                add(upper, val);
                highSize++;
                highSum += val;
            }
        }

        long getCost() {
            int median = lower.lastKey();

            long left = (long)median * lowSize - lowSum;
            long right = highSum - (long)median * highSize;

            return left + right;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        long[] cost = new long[n - x + 1];

        DualSet ds = new DualSet();

        // Sliding window

        for(int i = 0; i < n; i++) {
            ds.add(nums[i]);

            if(i >= x) {
                ds.remove(nums[i - x]);
            }

            if(i >= x - 1) {
                cost[i - x + 1] = ds.getCost();
            }
        }

        // DP

        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[n + 1][k + 1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select a window ending at i-1
                if(j > 0 && i >= x && dp[i - x][j - 1] != INF) {

                    long take = dp[i - x][j - 1] + cost[i - x];

                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[n][k];
    }
}