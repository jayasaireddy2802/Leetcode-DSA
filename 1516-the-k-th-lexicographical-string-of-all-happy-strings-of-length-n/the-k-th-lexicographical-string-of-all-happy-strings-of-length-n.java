class Solution {
    public void solve(int idx, char prevChar, StringBuilder sb, List<String> list, int n)
    {
        if(idx >= n)
        {
            list.add(new String(sb.toString()));
            return ;
        }
        
        for(char ch = 'a'; ch < 'd'; ch++)
        {
            if(ch == prevChar)
                continue;
            sb.append(ch);
            solve(idx + 1, ch, sb, list, n);
            sb.deleteCharAt(idx);
        }
    }
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int idx = 0;

        solve(idx, 'd', sb, list, n);
        if(list.size() >= k)
            return list.get(k-1);
        else
            return "";
    }
}