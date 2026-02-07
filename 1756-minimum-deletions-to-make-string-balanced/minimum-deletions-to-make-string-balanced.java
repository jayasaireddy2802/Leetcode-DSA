// class Solution {
//     public int minimumDeletions(String s) {
//         int len = s.length();
//         int mini = len;

//         for(int i = 0; i <= len; i++)
//         {
//             int ct = 0;
//             for(int j = i - 1; j >= 0; j--)
//             {
//                 if(s.charAt(j) == 'b')
//                     ct++;
//             }
//             for(int j = i; j < len; j++)
//             {
//                 if(s.charAt(j) == 'a')
//                     ct++;
//             }
//             mini = Math.min(ct, mini);
//         }

//         return mini;
//     }
// }


class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        int mini = len;

        int[] prefixCountofb = new int[len];
        int ct = 0;
        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == 'b')
                ct++;
            prefixCountofb[i] = ct;
        }

        int[] prefixCountofa = new int[len];
        ct = 0;
        for(int i = len - 1; i >= 0; i--)
        {
            if(s.charAt(i) == 'a')
                ct++;
            prefixCountofa[i] = ct;
        }


        for(int i = 0; i <= len; i++)
        {
            ct = 0;
            if(i-1 >= 0)
                ct += prefixCountofb[i - 1];
            if(i < len)
                ct += prefixCountofa[i];
            mini = Math.min(ct, mini);
        }

        return mini;
    }
}