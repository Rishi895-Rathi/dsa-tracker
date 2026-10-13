class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i = 2; i <= n; i++){
            boolean prime = true;

            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                if (sum + i > s) {
                    break;
                }
                sum += i;
                list.add(i);
            }
        }
        return list;
    }
}