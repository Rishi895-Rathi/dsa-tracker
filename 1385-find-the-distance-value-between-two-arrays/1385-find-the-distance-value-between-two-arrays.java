class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;

        for(int i = 0; i < arr1.length; i++){
            int left = 0;
            int right = arr2.length;

            int target = arr1[i] - d;

            while(left < right){
                int mid = left + (right - left) / 2;

                if(arr2[mid] < target){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }

            if(left == arr2.length || arr2[left] > arr1[i] + d){
                ans++;
            }
        }

        return ans;
    }
}