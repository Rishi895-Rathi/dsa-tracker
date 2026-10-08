class Solution {
    public int minAddToMakeValid(String s) {
        int openparan = 0 , closeparan = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                openparan++;
            }
            else{
                if(openparan > 0){
                    openparan--;
                }else{
                    closeparan++;
                }
            }
        }
        return openparan + closeparan;
    }
}