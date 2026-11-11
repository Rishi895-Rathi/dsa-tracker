class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1, need2);
        long cost = common * Math.min(costBoth, cost1 + cost2);
        int rem1 = need1 - (int)common;
        int rem2 = need2 - (int)common;
        cost += (long)rem1 * Math.min(costBoth, cost1);
        cost += (long)rem2 * Math.min(costBoth, cost2);
        return cost;
    }
}