import java.math.BigInteger;
class Solution {
    public int mySqrt(int x) {
        // double y=Math.exp((Math.log(x))*0.5);
        // return (int) Math.floor(y); my logic until error doesn't came

        //BigInteger bigInt = BigInteger.valueOf(x);
        //BigInteger sqrt = bigInt.sqrt();

        //return sqrt.intValue();

        int i = 0;
        while((long) i * i <= x){
            i++;
        }
        return i - 1;        
    }
}