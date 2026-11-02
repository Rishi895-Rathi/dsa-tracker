class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;

        for(int i = 0; i < timeSeries.length; i++){
            if(i == timeSeries.length - 1 || timeSeries[i] + duration <= timeSeries[i + 1]) {
                count += duration;
            }else{
                count += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return count;
    }
}