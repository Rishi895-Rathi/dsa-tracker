class Solution {
    static final int MOD = 1_000_000_007;
    long[] sum;
    long[] square;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = last[nums[i]] + 1;
            update(1, 0, n - 1, left, i);
            last[nums[i]] = i;
            ans = (ans + square[1]) % MOD;
        }

        return (int) ans;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0) return;

        long val = lazy[node];
        long len = r - l + 1;

        square[node] = (square[node] + 2 * val * sum[node] % MOD
                       + val * val % MOD * len % MOD) % MOD;
        sum[node] = (sum[node] + val * len) % MOD;

        if (l != r) {
            lazy[node * 2] = (lazy[node * 2] + val) % MOD;
            lazy[node * 2 + 1] = (lazy[node * 2 + 1] + val) % MOD;
        }

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        push(node, l, r);

        if (r < ql || l > qr) return;

        if (ql <= l && r <= qr) {
            lazy[node] = 1;
            push(node, l, r);
            return;
        }

        int mid = l + (r - l) / 2;

        update(node * 2, l, mid, ql, qr);
        update(node * 2 + 1, mid + 1, r, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        square[node] = (square[node * 2] + square[node * 2 + 1]) % MOD;
    }
}