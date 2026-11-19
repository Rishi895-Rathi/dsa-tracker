// class Solution {
//     HashSet<Integer> set = new HashSet<>();
//     public boolean isHappy(int n) {
//         if(n == 1) return true;
//         if(set.contains(n)) return false;
//         set.add(n);
//         int sum = 0;
//         while(n > 0){
//             int rem = n % 10;
//             sum += rem * rem;
//             n /= 10;
//         }
//         return isHappy(sum);
//     }
// }

// APPROACH TWO – USING THE "Floyd's Cycle Detection Algorithm"

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while(slow != fast);
        return slow == 1;
    }

    public int getSum(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}