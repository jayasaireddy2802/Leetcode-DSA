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
            char c = word.charAt(i);
            if(ch == c)
                ct++;
            else
                ch = c;
        }

        return ct;
    }
}