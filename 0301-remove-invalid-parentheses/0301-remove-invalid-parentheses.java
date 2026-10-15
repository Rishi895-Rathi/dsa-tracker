class Solution {
    Set<String> result = new HashSet<>();
    int minRemove = Integer.MAX_VALUE;
    public List<String> removeInvalidParentheses(String s){
        solve(s, 0, "", 0, 0);
        return new ArrayList<>(result);
    }

    void solve(String s, int index, String current, int count, int removals) {
        if(count < 0){
            return;
        }
        if(index == s.length()){
            if(count == 0){
                if(removals < minRemove){
                    minRemove = removals;
                    result.clear();
                    result.add(current);
                }else if (removals == minRemove){
                    result.add(current);
                }
            }
            return;
        }

        char ch = s.charAt(index);

        if(ch == '(' || ch == ')'){

            // remove
            solve(s, index + 1, current, count, removals + 1);

            // keep
            if(ch == '('){
                solve(s, index + 1, current + ch, count + 1, removals);
            }else{
                if(count > 0){
                    solve(s, index + 1, current + ch, count - 1, removals);
                }
            }
        }else{
            solve(s, index + 1, current + ch, count, removals);
        }
    }
}