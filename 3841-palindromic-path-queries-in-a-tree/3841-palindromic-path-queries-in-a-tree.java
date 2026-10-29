class Solution {
    List<Integer>[] adj;
    char[] chars;
    int[] tin, tout, depth, parent, base;
    int[][] up;
    int[] seg;
    int timer, LOG;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        chars = s.toCharArray();

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        up = new int[LOG][n];
        base = new int[n];

        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        timer = 0;
        stack[top++] = 0;
        parent[0] = 0;

        int[] rootMask = new int[n];

        while(top > 0){
            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;

            rootMask[u] = (u == 0 ? 0 : rootMask[parent[u]])  ^ (1 << (chars[u] - 'a'));

            base[tin[u]] = rootMask[u];
            for(int v : adj[u]){
                if(v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        int[] size = new int[n];
        Arrays.fill(size, 1);

        for(int i = n - 1; i > 0; i--){
            size[parent[order[i]]] += size[order[i]];
        }

        for(int i = 0; i < n; i++){
            tout[i] = tin[i] + size[i] - 1;
        }

        for(int i = 0; i < n; i++){
            up[0][i] = parent[i];
        }

        for(int j = 1; j < LOG; j++){
            for(int i = 0; i < n; i++){
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        seg = new int[4 * n];
        List<Boolean> ans = new ArrayList<>();

        for(String q : queries){
            String[] p = q.split(" ");

            if(p[0].equals("update")){
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
                chars[u] = c;

                if(delta != 0){
                    update(1, 0, n - 1, tin[u], tout[u], delta);
                }
            }else{
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int lca = findLCA(u, v);

                int mask = pointQuery(1, 0, n - 1, tin[u]) ^ pointQuery(1, 0, n - 1, tin[v]) ^ (1 << (chars[lca] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void update(int node, int l, int r, int ql, int qr, int val){
        if(ql <= l && r <= qr) {
            seg[node] ^= val;
            return;
        }

        int mid = l + (r - l) / 2;

        if(ql <= mid){
            update(node * 2, l, mid, ql, qr, val);
        }

        if(qr > mid){
            update(node * 2 + 1, mid + 1, r, ql, qr, val);
        }
    }

    private int pointQuery(int node, int l, int r, int idx){
        if(l == r){
            return base[idx] ^ seg[node];
        }

        int mid = l + (r - l) / 2;

        if(idx <= mid){
            return seg[node] ^ pointQuery(node * 2, l, mid, idx);
        }

        return seg[node] ^ pointQuery(node * 2 + 1, mid + 1, r, idx);
    }

    private int findLCA(int u, int v){
        if(depth[u] < depth[v]){
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for(int j = 0; j < LOG; j++){
            if((diff & (1 << j)) != 0){
                u = up[j][u];
            }
        }

        if(u == v) return u;

        for(int j = LOG - 1; j >= 0; j--){
            if(up[j][u] != up[j][v]){
                u = up[j][u];
                v = up[j][v];
            }
        }

        return parent[u];
    }
}