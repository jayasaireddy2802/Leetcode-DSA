// class Solution {
//     public String makeFancyString(String s) {
//         String str = "";
//         int i = 0, j = 0, ct = 1;
//         int len = s.length();
//         while(j < len)
//         {
//             if(j > 0 && s.charAt(j - 1) == s.charAt(j))
//             {
//                 ct++;
//             }
//             else
//             {
//                 ct = 1;
//             }
//             if(ct < 3)
//                 str = str + s.charAt(j);
//             j++;
//         }
//         return str;
//     }
// }


// class Solution {
//     public String makeFancyString(String s) {
//         StringBuilder sb = new StringBuilder();
//         int count = 1; // to count consecutive same characters
        
//         for (int i = 0; i < s.length(); i++) {
//             if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
//                 count++;
//             } else {
//                 count = 1;
//             }
            
//             if (count < 3) {
//                 sb.append(s.charAt(i));
//             }
//         }
        
//         return sb.toString();
//     }
// }

class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0, ct = 1;
        int len = s.length();

        while(j < len)
        {
            if(j > 0 && s.charAt(j - 1) == s.charAt(j))
            {
                ct++;
            }
            else
            {
                ct = 1;
            }
            if(ct < 3)
                str = str.append(s.charAt(j));
            j++;
        }
        return str.toString();
    }
}

