class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) < s.charAt(i - 1)){
                sorted = false;
                break;
            }
        }

        if(sorted) return 0;
        if(n == 2) return -1;

        char min = 'z', max = 'a';
        int minCount = 0, maxCount = 0;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c < min){
                min = c;
                minCount = 1;
            }else if(c == min){
                minCount++;
            }

            if(c > max){
                max = c;
                maxCount = 1;
            }else if(c == max){
                maxCount++;
            }
        }

        if(s.charAt(0) == min || s.charAt(n - 1) == max){
            return 1;
        }

        if(s.charAt(0) == max && s.charAt(n - 1) == min && maxCount == 1 && minCount == 1){
            return 3;
        }

        return 2;
    }
}