class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        PriorityQueue<int[]> free = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return Long.compare(a[0],b[0]);
        });

        for(int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i],i});
        }

        long time = 0;

        for(int i = 0; i < m; i++){

            time = Math.max(time,i);

            while(!busy.isEmpty() && busy.peek()[0] <= time){
                int[] curr = busy.poll();
                free.offer(new int[]{curr[1],curr[2]});
            }

            if(free.isEmpty()){
                time = busy.peek()[0];

                while(!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] curr = busy.poll();
                    free.offer(new int[]{curr[1],curr[2]});
                }
            }

            int[] server = free.poll();

            ans[i] = server[1];

            busy.offer(new int[]{
                (int)(time + tasks[i]),
                server[0],
                server[1]
            });
        }

        return ans;
    }
}