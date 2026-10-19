class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '['){
                nums.push(num);
                strs.push(sb);

                sb = new StringBuilder();
                num = 0;
            }
            else if(ch == ']'){
                int k = nums.pop();
                StringBuilder prev = strs.pop();

                for(int i = 0; i < k; i++){
                    prev.append(sb);
                }

                sb = prev;
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}