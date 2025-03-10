class Solution {

    private boolean isVowel(char ch)
    {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');    
    }

    public long countOfSubstrings(String word, int k) {
        int len = word.length();
        long ct = 0;
        Map<Character, Integer> map = new HashMap<>();
        int consonantCount = 0;

        // preprocessing
        int idx = len;
        int[] nextConsonant = new int[len];

        for(int j = len - 1; j >= 0; j--)
        {
            nextConsonant[j] = idx;
            if(!isVowel(word.charAt(j)))
            {
                idx = j;
            }
        }

        int i = 0, j = 0;
        while(j < len)
        {
            char ch = word.charAt(j);

            if(isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            else{
                consonantCount++;
            }
            
            while(consonantCount > k)
            {
                ch = word.charAt(i);
                if(isVowel(ch))
                {
                    int val = map.get(ch);
                    if(val == 1)
                        map.remove(ch);
                    else
                        map.put(ch, map.get(ch) - 1);
                }
                else
                    consonantCount--;
                i++;
            }

            while(map.size() == 5 && consonantCount == k)
            {
                ct = ct + nextConsonant[j] - j;
                ch = word.charAt(i);
                if(isVowel(ch))
                {
                    int val = map.get(ch);
                    if(val == 1)
                        map.remove(ch);
                    else
                        map.put(ch, map.get(ch) - 1);
                }
                else
                    consonantCount--;

                i++;
            }
            j++;
        }

        return ct;
    }
}


