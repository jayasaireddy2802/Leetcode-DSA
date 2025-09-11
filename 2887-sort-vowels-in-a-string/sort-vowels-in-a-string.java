// class Solution {

//     private boolean isVowel(char ch)
//     {
//         ch = Character.toLowerCase(ch);
//         if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
//             return true;
//         return false;
//     }

//     public String sortVowels(String s) {
//         List<Character> list = new ArrayList<>();
//         char[] arr = s.toCharArray();
//         int len = arr.length;

//         for(char ch : arr)
//         {
//             if(isVowel(ch))
//             {
//                 list.add(ch);
//             }
//         }

//         Collections.sort(list);
//         int j = 0;

//         for(int i = 0; i < len; i++)
//         {
//             if(isVowel(arr[i]))
//             {
//                 arr[i] = list.get(j);
//                 j++;
//             }
//         }

//         return new String(arr);
//     }
// }


// class Solution {

//     private boolean isVowel(char ch)
//     {
//         ch = Character.toLowerCase(ch);
//         return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');            
//     }

//     public String sortVowels(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         char[] arr = s.toCharArray();
//         int len = arr.length;

//         for(char ch : arr)
//         {
//             if(isVowel(ch))
//             {
//                 map.put(ch, map.getOrDefault(ch, 0) + 1);
//             }
//         }

//         String sortedVowel = "AEIOUaeiou";
//         int l = sortedVowel.length();
//         int idx = 0;

//         for(int i = 0; i < len; i++)
//         {
//             if(isVowel(arr[i]))
//             {
//                 char ch;
//                 while(idx < l && map.getOrDefault(sortedVowel.charAt(idx), 0) == 0)
//                 {
//                     idx++;
//                 }
//                 if(idx < l){
//                     ch = sortedVowel.charAt(idx); 
//                     arr[i] = ch;
//                     map.put(ch, map.get(ch) - 1);
//                 }
//             }
//         }

//         return new String(arr);
//     }
// }


import java.util.*;

class Solution {

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        // Step 1: Count frequencies of vowels (case-sensitive kept)
        int[] freq = new int[128]; // ASCII
        for (char ch : arr) {
            if (isVowel(ch)) {
                freq[ch]++;
            }
        }

        // Step 2: Iterate vowels in sorted order
        String order = "AEIOUaeiou";  // maintain lexicographic order
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (isVowel(arr[i])) {
                // Find next available vowel
                while (idx < order.length() && freq[order.charAt(idx)] == 0) {
                    idx++;
                }
                arr[i] = order.charAt(idx);
                freq[order.charAt(idx)]--;
            }
        }

        return new String(arr);
    }
}
