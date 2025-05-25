class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for(String word : words)
        {
            String reverseWord = new StringBuilder(word).reverse().toString();
            if(map.getOrDefault(reverseWord, 0) > 0)
            {
                ans = ans + 4;
                map.put(reverseWord, map.get(reverseWord) - 1);
            }
            else
                map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(String word : map.keySet())
        {
            if(word.charAt(0) == word.charAt(1) && map.get(word) > 0)
            {
                ans += 2;
                break;
            }
        }

        return ans;
    }
}