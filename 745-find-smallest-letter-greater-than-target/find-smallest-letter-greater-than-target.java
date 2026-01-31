// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         for(char ch : letters)
//         {
//             if(ch - target > 0)
//                 return ch;
//         }

//         return letters[0];
//     }
// }

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       int len = letters.length;
       int i = 0, j = len - 1;

       while(i <= j)
       {
            int mid = (i + j)/2;
            if(letters[mid] > target)
            {
                j = mid - 1;
            }
            else
                i = mid + 1;
       }
       return letters[i % len];
    }
}