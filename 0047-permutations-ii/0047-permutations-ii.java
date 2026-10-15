class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        backtrack(result, new ArrayList<>(), map, nums.length);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> path, Map<Integer, Integer> map, int n) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : map.keySet()) {
            int count = map.get(num);            
            if (count == 0) continue;
            path.add(num);
            map.put(num, count - 1);
            backtrack(result, path, map, n);
            path.remove(path.size() - 1);
            map.put(num, count);
        }
    }
}