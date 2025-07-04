// class Solution {

//     public String changeString(String str, int op)
//     {
//         if(op == 0)
//             return str = str + str;
//         else
//         {
//             int len = str.length();
//             int i = 0;

//             while(i < len)
//             {
//                 char nextChar = (char)(((str.charAt(i) - 'a' + 1) % 26) + 'a');
//                 str = str + nextChar;
//                 i++;
//             }

//             return str;
//         }
//     }
    
//     public char kthCharacter(long k, int[] operations) {

//         String ans = "a";
//         int idx = (int)k;
//         for(int op : operations)
//         {
//             ans = changeString(ans, op);
//             if(ans.length() >= k)
//                 return ans.charAt(idx - 1);
//         }

//         return ans.charAt(idx - 1);        
//     }
// }


class Solution {
    public char kthCharacter(long k, int[] ops) {
        if (k == 1) return 'a';

        int n = ops.length;
        int type = 0;
        long len = 1;
        long pos = k;

        for (int i = 0; i < n; i++) {
            len *= 2;
            if (len >= k) {
                type = ops[i];
                pos = k - len / 2;
                break;
            }
        }

        char ch = kthCharacter(pos, ops);

        if (type == 0) return ch;

        return ch == 'z' ? 'a' : (char)(ch + 1);
    }
}
