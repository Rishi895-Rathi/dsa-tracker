class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'b'){
                bCount++;
            }
            else{
                count = Math.min(count+1,bCount);
            }
        }

        return count;
    }
}