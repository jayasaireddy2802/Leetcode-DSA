// class Solution {
//     public void solve(int idx, char prevChar, StringBuilder sb, List<String> list, int n)
//     {
//         if(idx >= n)
//         {
//             list.add(new String(sb.toString()));
//             return ;
//         }
        
//         for(char ch = 'a'; ch < 'd'; ch++)
//         {
//             if(ch == prevChar)
//                 continue;
//             sb.append(ch);
//             solve(idx + 1, ch, sb, list, n);
//             sb.deleteCharAt(idx);
//         }
//     }
//     public String getHappyString(int n, int k) {
//         StringBuilder sb = new StringBuilder();
//         List<String> list = new ArrayList<>();
//         int idx = 0;

//         solve(idx, 'd', sb, list, n);
//         if(list.size() >= k)
//             return list.get(k-1);
//         else
//             return "";
//     }
// }


class Solution {
    int ct;
    public String solve(int idx, char prevChar, StringBuilder sb, int n, int k)
    {
        if(idx >= n)
        {
            if(k == ct)
                return sb.toString();
            ct++;
            return "";
        }
        
        for(char ch = 'a'; ch < 'd'; ch++)
        {
            if(ch == prevChar)
                continue;
            sb.append(ch);

            String str = solve(idx + 1, ch, sb, n, k);
            if(!str.equals(""))
                return str;
            sb.deleteCharAt(sb.length() -1 );
        }
        return "";
    }
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        ct = 0;
        String str = solve(idx, 'd', sb, n, k-1);
        return str;
    }
}