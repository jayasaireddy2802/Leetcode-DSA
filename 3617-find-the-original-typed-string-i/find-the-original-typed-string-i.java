// class Solution {
//     public int possibleStringCount(String word) {
//         int ct = 1;
//         int len = word.length();

//         for(int i = 1; i < len; i++)
//         {   
//             if(word.charAt(i) == word.charAt(i-1))
//                 ct++;
//         }

//         return ct;
//     }
// }


class Solution {
    public int possibleStringCount(String word) {
        int ct = 1;
        int len = word.length();
        char ch = word.charAt(0);

        for(int i = 1; i < len; i++)
        {   
            if(ch == word.charAt(i))
                ct++;
            else
                ch = word.charAt(i);
        }

        return ct;
    }
}