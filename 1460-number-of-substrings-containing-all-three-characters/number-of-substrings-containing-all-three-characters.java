class Solution {
    public int numberOfSubstrings(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = s.length();
        int ct = 0;

        while(j < len)
        {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() == 3)
            {
                ct = ct + (len - j);
                ch = s.charAt(i);
                if(map.get(ch) == 1)
                {
                    map.remove(ch);
                }
                else
                {
                    map.put(ch, map.get(ch) - 1);
                }
                i++;
            }

            j++;
        } 
        
        return ct;
    }
}