class Solution {
    public int minimumPushes(String word) {
        int val = 0;
        int ans = 0;
        int len = word.length();
        int[] freq = new int[26];


        for(int i = 0; i < len; i++)
        {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        for(int i = 25; i >= 0; i--)
        {
            if(freq[i] == 0) continue;
            int push = (val / 8) + 1;
            ans = ans + (push * freq[i]);
            val++;
        }

        return ans;

    }
}