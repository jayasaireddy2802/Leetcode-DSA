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

// class Solution {
//     public int canBeTypedWords(String text, String brokenLetters) {
//         String[] list = text.split(" ");
//         Set<Character> set = new HashSet<>();

//         for(char ch : brokenLetters.toCharArray())
//             set.add(ch);
         
//         int ct = 0;

//         for(String str : list)
//         {
//             boolean canType = true;
//             for(char ch : str.toCharArray())
//             {
//                 if(set.contains(ch))
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


// class Solution {
//     public int canBeTypedWords(String text, String brokenLetters) {
//         String[] list = text.split(" ");
//         boolean[] broken = new boolean[28];

//         for(char ch : brokenLetters.toCharArray())
//         {
//             broken[ch - 'a'] = true;
//         }
         
//         int ct = 0;

//         for(String str : list)
//         {
//             boolean canType = true;
//             for(char ch : str.toCharArray())
//             {
//                 if(broken[ch - 'a'])
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
        boolean[] broken = new boolean[26]; // 26 is enough for lowercase a-z

        // Mark broken letters
        for (int i = 0; i < brokenLetters.length(); i++) {
            char ch = brokenLetters.charAt(i);
            broken[ch - 'a'] = true;
        }

        int ct = 0;

        // Check each word
        for (int i = 0; i < list.length; i++) {
            String str = list[i];
            boolean canType = true;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (broken[ch - 'a']) {
                    canType = false;
                    break;
                }
            }

            if (canType) {
                ct++;
            }
        }

        return ct;
    }
}
