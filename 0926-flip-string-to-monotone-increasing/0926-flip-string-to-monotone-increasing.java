class Solution {
    public int minFlipsMonoIncr(String s) {

        // This is the same code i just used in the problem 1653. Minimum Deletions to Make String Balanced
        
        int bCount = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                bCount++;
            }
            else{
                count = Math.min(count+1,bCount);
            }
        }

        return count;
    }
}