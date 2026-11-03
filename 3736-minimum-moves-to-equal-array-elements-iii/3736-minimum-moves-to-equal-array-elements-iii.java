class Solution {
    public int minMoves(int[] nums) {
        int val = 0;

        for(int i : nums){
            val = Math.max(val , i);
        }
        
        int count = 0;
        for(int i : nums){
            count += val - i;
        }

        return count;
    }
}