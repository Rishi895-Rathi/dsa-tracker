// class Solution {
//     public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
//         HashMap<Integer,Integer> count = new HashMap<>();
//         HashMap<Integer,Integer> freeTime = new HashMap<>();
//         for(int i = 0; i < k; i++){
//             count.put(i,0);
//             freeTime.put(i,0);
//         }
//         for(int i = 0; i < arrival.length; i++){
//             int server = i % k;
//             int checked = 0;
//             while(checked < k){
//                 if(freeTime.get(server) <= arrival[i]){
//                     count.put(server,count.get(server) + 1);
//                     freeTime.put(server,arrival[i] + load[i]);
//                     break;
//                 }

//                 server = (server + 1) % k;
//                 checked++;
//             }
//         }
//         int max = 0;
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0; i < k; i++){
//             if(count.get(i) > max){
//                 max = count.get(i);
//                 ans.clear();
//                 ans.add(i);
//             }
//             else if(count.get(i) == max){
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );
        int[] count = new int[k];
        for(int i = 0; i < k; i++){
            free.add(i);
        }
        for(int i = 0; i < arrival.length; i++){
            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
                int[] curr = busy.poll();
                free.add(curr[1]);
            }
            if(free.isEmpty()){
                continue;
            }
            int server = i % k;
            Integer assigned = free.ceiling(server);
            if(assigned == null){
                assigned = free.first();
            }
            free.remove(assigned);
            count[assigned]++;
            busy.offer(new int[]{arrival[i] + load[i], assigned});
        }
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(count[i] > max){
                max = count[i];
                ans.clear();
                ans.add(i);
            }
            else if(count[i] == max){
                ans.add(i);
            }
        }

        return ans;
    }
}