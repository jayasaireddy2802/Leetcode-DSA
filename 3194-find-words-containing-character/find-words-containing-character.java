// class Solution {
//     public List<Integer> findWordsContaining(String[] words, char x) {
//         List<Integer> list = new ArrayList<>();
//         int len = words.length;
//         for(int i = 0; i < len; i++)
//         {
//             if(words[i].contains(Character.toString(x)))
//                 list.add(i);
//         }
//         return list;
//     }
// }

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int len = words.length;
        for(int i = 0; i < len; i++)
        {
            if(words[i].chars().anyMatch(ch -> ch == x))
                list.add(i);
        }
        return list;
    }
}