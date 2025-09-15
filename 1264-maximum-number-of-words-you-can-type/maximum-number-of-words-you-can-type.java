// class Solution {
//     public int canBeTypedWords(String text, String brokenLetters) {
//         String[] list = text.split(" ");
//         char[] arr = brokenLetters.toCharArray();
//         int ct = 0;

//         for(String str : list)
//         {
//             boolean canType = true;
//             for(char ch : arr)
//             {
//                 if(str.indexOf(ch) != -1)
//                 {
//                     canType = false;
//                     break;
//                 }
//             }
//             if(canType)
//                 ct++;
//         }

//         return ct;
//     }
// }

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] list = text.split(" ");
        Set<Character> set = new HashSet<>();

        for(char ch : brokenLetters.toCharArray())
            set.add(ch);
         
        int ct = 0;

        for(String str : list)
        {
            boolean canType = true;
            for(char ch : str.toCharArray())
            {
                if(set.contains(ch))
                {
                    canType = false;
                    break;
                }
            }
            if(canType)
                ct++;
        }

        return ct;
    }
}