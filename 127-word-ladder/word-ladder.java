class Pair
{
    int lvl;
    String str;

    public Pair(String str, int lvl)
    {
        this.lvl = lvl;
        this.str = str;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        int wordsLength = wordList.size();

        for(String str : wordList)
            set.add(str);

        queue.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!queue.isEmpty())
        {
            Pair p = queue.poll();
            int lvl = p.lvl;
            String str = p.str;
            int strLength = str.length();

            if(str.equals(endWord))
                return lvl;

            for(int i = 0; i < strLength; i++)
            {
                char[] arr = str.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    arr[i] = ch;
                    String newStr = new String(arr);

                    if(set.contains(newStr))
                    {
                        set.remove(newStr);
                        queue.add(new Pair(newStr, lvl + 1));
                    }
                }
            }

        }

        return 0;
    }
}