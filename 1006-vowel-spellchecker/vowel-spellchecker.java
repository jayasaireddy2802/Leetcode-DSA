// class Solution {

//     private boolean isVowel(char ch) {
//         return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
//     }

//     public String[] spellchecker(String[] wordlist, String[] queries) {
//         int len = queries.length;
//         String[] ans = new String[len];

//         for (int i = 0; i < len; i++) {
//             String s1 = queries[i].toLowerCase();
//             String str = "";
//             boolean flag = false;

            
//             for (String s2 : wordlist) {
//                 if (queries[i].equals(s2)) {   
//                     flag = true;
//                     str = s2;
//                     break;
//                 }
//             }

            
//             if (!flag) {
//                 for (String s2 : wordlist) {
//                     if (s1.equals(s2.toLowerCase())) {
//                         flag = true;
//                         str = s2;
//                         break;
//                     }
//                 }
//             }

            
//             if (!flag) {
//                 for (String s2 : wordlist) {
//                     String s = s2.toLowerCase();
//                     if (s1.length() != s.length()) continue;

//                     boolean match = true;
//                     for (int k = 0; k < s1.length(); k++) {
//                         char c1 = s1.charAt(k);
//                         char c2 = s.charAt(k);
//                         if (c1 != c2 && !(isVowel(c1) && isVowel(c2))) {
//                             match = false;
//                             break;
//                         }
//                     }

//                     if (match) {
//                         flag = true;
//                         str = s2;   
//                         break;
//                     }
//                 }
//             }

//             ans[i] = flag ? str : "";
//         }

//         return ans;
//     }
// }



import java.util.*;

class Solution {

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        // Build lookup maps
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(devowel(lower), word);
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactWords.contains(q)) {
                ans[i] = q;   // exact match
            } else {
                String lower = q.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    ans[i] = caseInsensitive.get(lower);  // case-insensitive match
                } else {
                    String dev = devowel(lower);
                    ans[i] = vowelInsensitive.getOrDefault(dev, "");  // vowel match
                }
            }
        }

        return ans;
    }
}
