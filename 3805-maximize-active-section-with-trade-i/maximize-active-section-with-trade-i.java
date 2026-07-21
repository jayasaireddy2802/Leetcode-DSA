class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> list = new ArrayList<>();
        int len = s.length();
        int ct = 0;
        int ans = 0;
        int onesCnt = 0;

        for(int i = 0; i < len; i++)
        {
            if(s.charAt(i) == '0')
                ct++;
            else
            {
                onesCnt++;
                if(ct != 0)
                list.add(ct);
                ct = 0;
            }
        }
        if(s.charAt(len - 1) == '0')
        list.add(ct);

        int size = list.size();

        for(int i = 1; i < size; i++)
        {
            ans = Math.max(ans, list.get(i - 1) + list.get(i));
        }

        return ans + onesCnt;
    }
}