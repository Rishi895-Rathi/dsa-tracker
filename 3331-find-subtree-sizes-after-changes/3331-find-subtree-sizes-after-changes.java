class Solution {
    int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            adj.get(parent[i]).add(i);
        }

        int[] newParent=new int[n];

        HashMap<Character,Integer> map=new HashMap<>();

        dfs(0,adj,parent,s,map,newParent);

        List<List<Integer>> tree=new ArrayList<>();

        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            tree.get(newParent[i]).add(i);
        }
        ans=new int[n];
        calculate(0,tree);
        return ans;
    }

    void dfs(int node,List<List<Integer>> adj,int[] parent, String s,HashMap<Character,Integer> map,int[] newParent) {

        char ch=s.charAt(node);

        int old=map.getOrDefault(ch,-1);

        if(node==0){
            newParent[node]=-1;
        }else{
            newParent[node]=old==-1 ? parent[node] : old;
        }

        map.put(ch,node);

        for(int child:adj.get(node)){
            dfs(child,adj,parent,s,map,newParent);
        }

        if(old==-1){
            map.remove(ch);
        }else{
            map.put(ch,old);
        }
    }

    int calculate(int node,List<List<Integer>> tree){
        int size=1;

        for(int child:tree.get(node)){
            size+=calculate(child,tree);
        }
        ans[node]=size;
        return size;
    }
}