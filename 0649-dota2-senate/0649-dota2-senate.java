// class Solution {
//     public String predictPartyVictory(String senate) {
//         Queue<Integer> r = new LinkedList<>();
//         Queue<Integer> d = new LinkedList<>();

//         int n = senate.length();

//         for(int i = 0; i < n; i++) {
//             if(senate.charAt(i) == 'R'){
//                 r.offer(i);
//             }else{
//                 d.offer(i);
//             }
//         }

//         while(!r.isEmpty() && !d.isEmpty()){
//             int ri = r.poll();
//             int di = d.poll();

//             if(ri < di){
//                 r.offer(ri + n);
//             }else{
//                 d.offer(di + n);
//             }
//         }

//         return r.isEmpty() ? "Dire" : "Radiant";
//     }
// }

// APPROACH TWO
class Solution {
    public String predictPartyVictory(String senate) {
        
        Deque<Character> deque = new ArrayDeque<>();
        int rCount = 0;
        int dCount = 0;
        int rBanned = 0;
        int dBanned = 0;

        for (int i = 0; i < senate.length(); ++i) {
            deque.addLast(senate.charAt(i));
            if (senate.charAt(i) == 'R') {
                ++rCount;
            }
            else {
                ++dCount;
            }
        }
        
        while (rCount != 0 && dCount != 0) {
            
            char senator = deque.removeFirst();
            if (senator == 'R') {
                if (rBanned > 0) {
                    --rBanned;
                    --rCount;
                }
                else {
                    ++dBanned;
                    deque.addLast(senator);
                }
            }
            else {
                if (dBanned > 0) {
                    --dBanned;
                    --dCount;
                }
                else {
                    ++rBanned;
                    deque.addLast(senator);
                }
            }
        }

        return rCount == 0 ? "Dire" : "Radiant";        
    }
}