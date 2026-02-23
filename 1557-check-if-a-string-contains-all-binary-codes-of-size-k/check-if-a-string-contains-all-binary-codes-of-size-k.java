class Solution {
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        int i = 0;
        Set<String> set = new HashSet<>();

        while((i + k - 1) < len)
        {
            String str = s.substring(i, i + k);
            set.add(str);
            i++;
        }

        return (set.size() == Math.pow(2, k)) ? true : false;
        
    }
}