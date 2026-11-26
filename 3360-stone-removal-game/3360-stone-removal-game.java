class Solution {
    public boolean canAliceWin(int n) {
        int remove=10,count=0;

        while(n >= remove){
            n -= remove;
            remove--;
            count++;
        }

        return count%2==1;
    }
}

// approach two 


// class Solution {
//     public boolean canAliceWin(int n) {
//         int remove=10;
//         boolean alice=true;

//         while(n>=remove){
//             n-=remove;
//             remove--;
//             alice=!alice;
//         }

//         return !alice;
//     }
// }
