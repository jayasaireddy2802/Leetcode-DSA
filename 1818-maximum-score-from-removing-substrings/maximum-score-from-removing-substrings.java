// class Solution {

//     public String remove(String s, String str)
//     {
//         int len = s.length();
//         Stack<Character> st = new Stack<>();
//         char ch = str.charAt(1);
//         int j = 0;

//         while(j < len)
//         {
//             if(s.charAt(j) == ch && (!st.isEmpty() && st.peek() == str.charAt(0)))
//             {
//                 st.pop();
//             }
//             else 
//                 st.push(s.charAt(j));
//             j++;
//         }

//         String newString = "";
//         while(!st.isEmpty())
//         {
//             newString = newString + st.pop();            
//         }

        
//         String reversed = "";

//         for (int i = newString.length() - 1; i >= 0; i--) {
//             reversed += newString.charAt(i);
//         }

//         return reversed;

//     }

//     public int maximumGain(String s, int x, int y){
//         int len = s.length();
//         String maxString = "";
//         String minString = "";
//         int ans = 0, maxVal, minVal;

//         if(x > y)
//         {
//             maxString = "ab";
//             minString = "ba";
//             maxVal = x;
//             minVal = y;
//         }
//         else
//         {
//             maxString = "ba";
//             minString = "ab";
//              maxVal = y;
//             minVal = x;
//         }

//         String newString = remove(s, maxString);
//         ans = maxVal*((len - newString.length())/2);
//         len = newString.length();
//         newString = remove(newString, minString);
//         ans = ans + minVal*((len - newString.length())/2);

//         return ans;
//     }
// }

class Solution {

    public String remove(String s, String str)
    {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        char ch = str.charAt(1);
        int j = 0;

        while(j < len)
        {
            if(s.charAt(j) == ch && (!st.isEmpty() && st.peek() == str.charAt(0)))
            {
                st.pop();
            }
            else 
                st.push(s.charAt(j));
            j++;
        }

        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }

        return sb.reverse().toString();

    }

    public int maximumGain(String s, int x, int y){
        int len = s.length();
        String maxString = "";
        String minString = "";
        int ans = 0, maxVal, minVal;

        if(x > y)
        {
            maxString = "ab";
            minString = "ba";
            maxVal = x;
            minVal = y;
        }
        else
        {
            maxString = "ba";
            minString = "ab";
             maxVal = y;
            minVal = x;
        }

        String newString = remove(s, maxString);
        ans = maxVal*((len - newString.length())/2);
        len = newString.length();
        newString = remove(newString, minString);
        ans = ans + minVal*((len - newString.length())/2);

        return ans;
    }
}