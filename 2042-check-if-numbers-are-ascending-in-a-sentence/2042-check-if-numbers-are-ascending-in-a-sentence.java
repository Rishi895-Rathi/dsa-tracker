// class Solution {
//     public boolean areNumbersAscending(String s) {
//         String[] arr = s.split(" ");
//         int temp =- 1;

//         for(int i = 0; i < arr.length; i++){

//             // \\d = any digit (0-9), \\d+ = one or more digits, \\d* = zero or more digits.
//             // We use \\ instead of \ because backslash is an escape character in Java strings.
//             if(arr[i].matches("\\d+")){
//                 int num = Integer.parseInt(arr[i]);
//                 if(num <= temp){
//                     return false;
//                 }
//                 temp = num;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean areNumbersAscending(String s) {
        String[] parts = s.split(" ");

        int pre = -1;

        for(int i=0;i<parts.length;i++){
            char ch = parts[i].charAt(0);

            if(ch >= '0' && ch <= '9'){
                int val = Integer.parseInt(parts[i]);

                if(pre >= val){
                    return false;
                }

                pre = val;
            }
        }

        return true;
    }
}