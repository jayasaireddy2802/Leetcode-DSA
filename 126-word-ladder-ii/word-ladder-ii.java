// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         List<List<String>> ans = new ArrayList<>();
//         Queue<ArrayList<String>> queue = new LinkedList<>();
//         Set<String> set = new HashSet<>();
//         Set<String> usedWords = new HashSet<>();
//         boolean found = false;
        
//         for(String str : wordList)
//             set.add(str);
            
//         ArrayList<String> list = new ArrayList<>();
//         list.add(beginWord);
//         queue.add(list);
//         set.remove(beginWord);
        
//         while(!queue.isEmpty() && !found)
//         {
//             int size = queue.size();
//             usedWords.clear();
            
//             for(int i = 0; i < size; i++)
//             {
//                 list = queue.poll();
//                 String prevStr = list.get(list.size() - 1);
                
//                 if(prevStr.equals(endWord))
//                 {
//                     ans.add(new ArrayList<>(list));
//                     found = true;
//                     continue;
//                 }
                
//                 char[] arr = prevStr.toCharArray();
//                 for(int j = 0; j < prevStr.length(); j++)
//                 {
//                     char prevChar = arr[j];
//                     for(char ch = 'a'; ch <= 'z'; ch++)
//                     {
//                         arr[j] = ch;
//                         String newWord = new String(arr);
                        
//                         if(set.contains(newWord))
//                         {
//                             usedWords.add(newWord);
//                             ArrayList<String> newList = new ArrayList<>(list);
//                             newList.add(newWord);
//                             queue.add(newList);
//                         }
//                     }
//                     arr[j] = prevChar;
//                 }
//             }
            
//             for(String str : usedWords)
//             {
//                 set.remove(str);
//             }
//         }
        
//         return ans;
//     }
// }



// optimal solution not interviews
class Solution {

    public Map<String, Integer> wordLadder1(String beginWord, String endWord, List<String> wordList)
    {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for(String str : wordList)
            set.add(str);

        queue.add(beginWord);
        map.put(beginWord, 0);
        set.remove(beginWord);

        while(!queue.isEmpty())
        {
            String prevStr = queue.poll();
            int lvl = map.get(prevStr);
            char[] charArr = prevStr.toCharArray();
            int len = prevStr.length();

            if(prevStr.equals(endWord))
                return map;

            for(int i = 0; i < len; i++)
            {
                char prevChar = charArr[i];
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    charArr[i] = ch;
                    String newWord = new String(charArr);

                    if(set.contains(newWord))
                    {
                        queue.add(newWord);
                        map.put(newWord, lvl + 1);
                        set.remove(newWord);
                    }
                }
                charArr[i] = prevChar; 
            }
        }

        return map;
    }

    public void dfs(String beginWord, String endWord, List<String> list, Map<String, Integer> map, List<List<String>> ans, Set<String> set)
    {
        int lvl = map.getOrDefault(endWord, -1);

        if(endWord.equals(beginWord))
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        char[] charArr = endWord.toCharArray();
        int len = endWord.length();

        for(int i = 0; i < len; i++)
        {
            char prevChar = charArr[i];
            for(char ch = 'a'; ch <= 'z'; ch++)
            {
                charArr[i] = ch;
                String newWord = new String(charArr);

                if(map.containsKey(newWord) && map.getOrDefault(newWord, -1) == lvl - 1)
                {
                    list.add(0, newWord);
                    dfs(beginWord, newWord, list, map, ans, set);
                    list.remove(0);
                }
            }
            charArr[i] = prevChar;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
            
        map = wordLadder1(beginWord, endWord, wordList);

        Set<String> set = new HashSet<>();

        for(String str : wordList)
            set.add(str);

        list.add(endWord);
        dfs(beginWord, endWord, list, map, ans, set);
        return ans;

    }
}




      