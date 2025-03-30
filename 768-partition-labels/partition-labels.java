class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int len = s.length();

        int[] map = new int[26];
        for(int i = 0; i < len; i++)
        {
            map[s.charAt(i) - 'a'] = i;
        }

        int i = 0, j = 0;
        int end = 0;

        while(i < len)
        {
            end = map[s.charAt(i) - 'a'];
            
            j = i;
            while(j < end)
            {
                end = Math.max(end, map[s.charAt(j) - 'a']);
                j++;
            }

            ans.add(j - i + 1);
            i = j + 1;
        } 

        return ans;       
    }
}