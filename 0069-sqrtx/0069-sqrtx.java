import java.math.BigInteger;
class Solution {
    public int mySqrt(int x) {

        // Log Approach
         
        // double y=Math.exp((Math.log(x))*0.5);
        // return (int) Math.floor(y); my logic until error doesn't came

        //Sqrt function Approach

        //BigInteger bigInt = BigInteger.valueOf(x);
        //BigInteger sqrt = bigInt.sqrt();

        //return sqrt.intValue();

        // Brute Force

        //int i = 0;
        //while((long) i * i <= x){
            //i++;
        //}
        //return i - 1;

        //Newton"s method 

        // long guess = x;
        // while(guess * guess > x){
        //     guess = (guess + (x / guess))/2;
        // }        

        //binary search

        long low = 0;
        long high = x;
        long guess = 0;

        while(low <= high){
            long mid = low + (high - low) / 2;
            if(mid * mid <= x){
                guess = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (int) guess;
    }
}