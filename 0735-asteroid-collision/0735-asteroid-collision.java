class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();
        for(int a : asteroids){
            boolean alive = true;

            while(alive && a < 0 && !res.isEmpty() && res.get(res.size()-1) > 0){
                int last = res.get(res.size()-1);

                if(last < -a){
                    res.remove(res.size()-1);
                }
                else if(last == -a){
                    res.remove(res.size()-1);
                    alive = false;
                }
                else{
                    alive = false;
                }
            }

            if(alive){
                res.add(a);
            }
        }

        int[] ans = new int[res.size()];

        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}