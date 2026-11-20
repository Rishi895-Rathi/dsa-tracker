class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int num:nums){
            int a=map.getOrDefault(num-1,0)+1;
            int b=map.getOrDefault(num,0)+1;
            map.put(num,Math.max(map.getOrDefault(num,0),a));
            map.put(num+1,Math.max(map.getOrDefault(num+1,0),b));

            ans=Math.max(ans,Math.max(map.get(num),map.get(num+1)));
        }
        return ans;
    }
}