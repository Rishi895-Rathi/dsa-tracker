class Solution {
    public int maxLength(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            long prod = 1;
            long gcd = nums[i];
            long lcm = nums[i];

            for(int j = i; j < nums.length; j++){
                prod *= nums[j];

                gcd = findGCD(gcd , nums[j]);
                lcm = findLCM(lcm , nums[j]);

                if(prod==gcd*lcm){
                    max = Math.max(max , j - i + 1);
                }
            }
        }

        return max;
    }

    public long findGCD(long a,long b){
        while(b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public long findLCM(long a,long b){
        return (a/findGCD(a,b))*b;
    }
}