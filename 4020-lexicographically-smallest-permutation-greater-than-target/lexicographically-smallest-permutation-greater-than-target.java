class Solution {
    String res = "";
    public boolean solve(int idx, String s, String target, int[] freq, boolean isgreater, StringBuilder sb)
    {
        int len = s.length();

        if(len == idx)
        {
            if (isgreater) {
                res = sb.toString();
                return true;
            }
            return false;
        }

        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            if(freq[ch - 'a'] == 0)
                continue;

            if(isgreater == false && ch < target.charAt(idx))
                continue; 
                
            sb.append(ch);
            freq[ch - 'a']--;

            if(solve(idx + 1, s, target, freq, (isgreater || ch > target.charAt(idx)), sb)) return true;

            sb.deleteCharAt(sb.length() - 1);
            freq[ch - 'a']++;
        }

        return false;

    }

    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        int len = s.length();
        boolean isgreater = false;

        for(int i = 0; i < len; i++)
        {
            freq[s.charAt(i) - 'a']++;
        }

         solve(0, s, target, freq, isgreater, new StringBuilder());

        return res;
    }
}