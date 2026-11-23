class Solution {
    public String sortSentence(String s) {

        String[] arr = s.split(" ");
        String[] temp = new String[arr.length];

        for(int i = 0; i < arr.length; i++){
            int n = arr[i].charAt(arr[i].length() - 1) - '0';

            temp[n - 1] = arr[i].substring(0,arr[i].length() - 1);
        }

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < temp.length; i++){
            res.append(temp[i]);

            if(i < temp.length - 1){
                res.append(" ");
            }
        }

        return res.toString();
    }
}