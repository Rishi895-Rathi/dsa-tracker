class Solution {
    public boolean threeFibonacciSum(int n) {
        long a = 0 , b = 1, c = 1;
        while(true){
            if(a + b + c == n){
                return true;
            }
            if(a + b + c > n){
                return false;
            }
            long temp = b + c;
            a = b;
            b = c;
            c = temp;
        }
    }
}