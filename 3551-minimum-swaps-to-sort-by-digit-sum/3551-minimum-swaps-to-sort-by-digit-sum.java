class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int num = nums[i];

            while(num>0){
                arr[i] += num%10;
                num /= 10;
            }
        }

        int[][] temp = new int[n][2];

        for(int i=0;i<n;i++){
            temp[i][0] = arr[i];
            temp[i][1] = nums[i];
        }

        Arrays.sort(temp,(a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });

        int[] target = new int[n];

        for(int i=0;i<n;i++){
            target[i] = temp[i][1];
        }

        Map<Integer,Integer> pos = new HashMap<>();

        for(int i=0;i<n;i++){
            pos.put(nums[i],i);
        }

        int swaps = 0;

        for(int i=0;i<n;i++){
            if(nums[i] != target[i]){
                int j = pos.get(target[i]);

                pos.put(nums[i],j);
                pos.put(target[i],i);

                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;

                swaps++;
            }
        }
        return swaps;
    }
}