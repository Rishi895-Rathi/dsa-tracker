class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashSet<String> set = new HashSet<>();
        for(String s : list1){
            set.add(s);
        }
        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for(int j = 0; j < list2.length; j++){
            if(set.contains(list2[j])){
                int i = 0;
                while(i < list1.length && !list1[i].equals(list2[j])){
                    i++;
                }
                int sum = i + j;
                if(sum < min){
                    min = sum;
                    ans.clear();
                    ans.add(list2[j]);
                }else if(sum == min){
                    ans.add(list2[j]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}