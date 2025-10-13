class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            list.add(words[i]);
        }

        int size = list.size();
        int i = 1;
        while (i < size) {
            boolean found = true;
            int[] freq1;
            int[] freq2;

            freq1 = new int[27];
            freq2 = new int[27];

            for (char ch : list.get(i-1).toCharArray()) {
                freq1[ch - 'a']++;
            }

            for (char ch : list.get(i).toCharArray()) {
                freq2[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (freq1[j] != freq2[j]) {
                    found = false;
                    break;
                }
            }

            if (found)
            {
                list.remove(i);
                size--;
            }
            else
                i++;
        }

        return list;
    }
}