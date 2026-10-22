class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;

        int count = 0;

        for(int i = 1; i < n; i++){
            int add = i - minJump;
            int remove = i - maxJump - 1;

            if(add >= 0 && dp[add]) count++;
            if(remove >= 0 && dp[remove]) count--;

            if(s.charAt(i) == '0' && count > 0){
                dp[i] = true;
            }
        }

        return dp[n - 1];

        //Approach two not working ............ to be solved in the future 

        // int n = s.length();
        // boolean[] dp = new boolean[n];

        // if(s.charAt(n - 1) == '1') return false;

        // if(maxJump < n && s.charAt(maxJump) == '0'){
        //     dp[maxJump] = true;

        //     for(int i = maxJump; i < n; i++){
        //         if(!dp[i]) continue;

        //         for(int j = i + maxJump; j >= i + minJump; j--){
        //             if(j < n && s.charAt(j) == '0'){
        //                 dp[j] = true;
        //             }
        //         }
        //     }
        // }
        // else if(minJump < n && s.charAt(minJump) == '0'){
        //     dp[minJump] = true;

        //     for(int i = minJump; i < n; i++){
        //         if(!dp[i]) continue;

        //         for(int j = i + maxJump; j >= i + minJump; j--){
        //             if(j < n && s.charAt(j) == '0'){
        //                 dp[j] = true;
        //             }
        //         }
        //     }
        // }
        // else{
        //     return false;
        // }

        // return dp[n - 1];
    }
}