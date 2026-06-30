// class Solution {
//     public int numberOfSubstrings(String s) {
//         int len = s.length();
//         int count_A = 0;
//         int count_B = 0;
//         int count_C = 0;
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             count_A = 0;
//             count_B = 0;
//             count_C = 0;
//             for(int j = i; j < len; j++)
//             {
//                 char ch = s.charAt(j);
//                 if(ch == 'a') count_A++;
//                 else if(ch == 'b') count_B++;
//                 else if(ch == 'c') count_C++;

//                 if(count_A > 0 && count_B > 0 && count_C > 0) ct++;
//             }
//         }

//         return ct;
//     }
// }



class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int count_A = 0;
        int count_B = 0;
        int count_C = 0;
        int ct = 0, i = 0, j = 0;

        while(j < len)
        {
            char ch = s.charAt(j);
            if(ch == 'a') count_A++;
            else if(ch == 'b') count_B++;
            else if(ch == 'c') count_C++;

            if(count_A > 0 && count_B > 0 && count_C > 0){
                ct = ct + len - j;

                while(i < j)
                {
                    ch = s.charAt(i);
                    if(ch == 'a') count_A--;
                    else if(ch == 'b') count_B--;
                    else if(ch == 'c') count_C--;
                    i++;
                    if(count_A > 0 && count_B > 0 && count_C > 0) ct = ct + len - j;
                    else break;
                }
            }
            
            j++;            
        }

        return ct;
    }
}