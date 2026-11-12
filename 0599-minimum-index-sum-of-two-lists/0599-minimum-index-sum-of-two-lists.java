class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < list1.length; i++){
            for(int j = 0; j < list2.length; j++){
                if(list1[i].equals(list2[j])){
                    int sum = i + j;
                    if(sum < min){
                        min = sum;
                        ans.clear();
                        ans.add(list1[i]);
                    }else if(sum == min){
                        ans.add(list1[i]);
                    }
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}