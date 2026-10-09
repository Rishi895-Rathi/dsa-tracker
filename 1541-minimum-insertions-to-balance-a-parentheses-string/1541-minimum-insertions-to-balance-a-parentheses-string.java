class Solution {
    public int minInsertions(String s) {
        int depth = 0;
        int insertions = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                depth++;
            }else{
                if(i + 1 < s.length() && s.charAt(i + 1) == ')'){
                    if(depth > 0){
                        depth--;
                    }else{
                        insertions++;
                    }
                    i++;
                }else{
                    if(depth > 0){
                        depth--;
                        insertions++;
                    }else{
                        insertions += 2;
                    }
                }
            }
        }
        insertions += depth * 2;
        return insertions;
    }
}