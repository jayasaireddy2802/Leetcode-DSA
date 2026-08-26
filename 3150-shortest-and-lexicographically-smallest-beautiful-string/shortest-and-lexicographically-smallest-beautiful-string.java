class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        List<String> list = new ArrayList<>();
        int res = len;

        int i = 0;
        int j = 0;
        int ones = 0;

        while(j < len)
        {
            if(s.charAt(j) == '1')
                ones++;

            while(ones > k)
            {
                if(s.charAt(i) == '1')
                    ones--;
                i++;
            }

            while (ones == k && s.charAt(i) == '0') {
                i++;
            }

            int size = j - i + 1;
            if(size < res && ones == k)
            {
                res = size;
                list.clear();
                list.add(s.substring(i, j + 1));
            }
            else if(size == res && ones == k)
            {
                list.add(s.substring(i, j + 1));
            }

            j++;
        }

        Collections.sort(list);

        return list.size() == 0 ? "" : list.get(0);
    }
}