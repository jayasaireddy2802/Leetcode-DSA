// class Solution {
//     public int findPartitions(StringBuilder sb, int k, int len)
//     {
//         Set<Character> set = new HashSet<>();

//         int res = 0;
//         for(int i = 0; i < len; i++)
//         {
//             char ch = sb.charAt(i);
//             if(set.size() == k && !set.contains(ch))
//             {
//                 res++;
//                 set.clear();
//             }
//             set.add(ch);
//         }
//         if (!set.isEmpty()) res++;
//         return res;
//     }

//     public int maxPartitionsAfterOperations(String s, int k) {
//         int ans = 0;

//         StringBuilder sb = new StringBuilder(s);
//         int len = s.length();

//         for(int i = 0; i < len ; i++)
//         {
//             char prevChar = s.charAt(i);
//             for(char ch = 'a'; ch <= 'z'; ch++)
//             {
//                 if(prevChar == ch) continue ;
//                 sb.setCharAt(i, ch);
//                 int ct = findPartitions(sb, k, len); 
//                 ans = Math.max(ans, ct);
//             }
//             sb.setCharAt(i, prevChar);
//         }

//         return ans;
//     }
// }



// import java.util.*;

// class Solution {

//     // Efficient partition finder (O(n))
//     private int findPartitions(char[] arr, int k) {
//         Set<Character> set = new HashSet<>();
//         int res = 0;

//         for (char ch : arr) {
//             if (set.size() == k && !set.contains(ch)) {
//                 res++;
//                 set.clear();
//             }
//             set.add(ch);
//         }

//         if (!set.isEmpty()) res++; // count last partition
//         return res;
//     }

//     public int maxPartitionsAfterOperations(String s, int k) {
//         int ans = 0;
//         int len = s.length();
//         char[] arr = s.toCharArray();

//         for (int i = 0; i < len; i++) {
//             char original = arr[i];

//             // Try replacing arr[i] with each letter from 'a' to 'z'
//             for (char ch = 'a'; ch <= 'z'; ch++) {
//                 if (ch == original) continue; // skip same letter

//                 arr[i] = ch;
//                 ans = Math.max(ans, findPartitions(arr, k));
//             }

//             arr[i] = original; // restore original
//         }

//         return ans;
//     }

// }


// recursion-cswithmik

// import java.util.*;

// class Solution {

    
//     private int findPartitions(int idx, int uniqueChars, int k, char[] arr, boolean canChange) {
//         if(idx >= arr.length)
//             return 0;

//         int updatedChars = uniqueChars | (1 << (arr[idx] - 'a'));
//         int result = 0;
//         int ct = Integer.bitCount(updatedChars);

//         if(ct > k)
//         {
//             result = 1 + findPartitions(idx + 1, (1 << arr[idx] - 'a'), k, arr, canChange);
//         }
//         else 
//             result = findPartitions(idx + 1, updatedChars, k, arr, canChange);

        
//         if(canChange)
//         {            
//             for(int i = 0; i < 26; i++)
//             {
//                 int newChars = uniqueChars | (1 << i); 
//                 int newct = Integer.bitCount(newChars);
//                 if(newct > k)
//                     result = Math.max(result, 1 + findPartitions(idx + 1, 1 << i, k, arr, false));
//                 else
//                     result = Math.max(result, findPartitions(idx+ 1, newChars, k, arr, false));
//             }
//         }

//         return result;        


//     }

//     public int maxPartitionsAfterOperations(String s, int k) {
//         int ans = 0;
//         int len = s.length();
//         char[] arr = s.toCharArray();

//         ans = findPartitions(0, 0, k, arr, true) + 1;

//         return ans;
//     }

// }

import java.util.*;

class Solution {

    private Map<Long, Integer> map = new HashMap<>();

    private int findPartitions(int idx, int uniqueChars, int k, char[] arr, boolean canChange) {
        if (idx >= arr.length)
            return 0;

        long key = (((long) idx) << 27) | (((long) uniqueChars) << 1) | (canChange ? 1L : 0L);
        if (map.containsKey(key))
            return map.get(key);

        // Correct parentheses here
        int updatedChars = uniqueChars | (1 << (arr[idx] - 'a'));
        int result;

        int ct = Integer.bitCount(updatedChars);

        // Case 1: Partition needed if > k distinct
        if (ct > k) {
            result = 1 + findPartitions(idx + 1, (1 << (arr[idx] - 'a')), k, arr, canChange);
        } else {
            result = findPartitions(idx + 1, updatedChars, k, arr, canChange);
        }

        // Case 2: Try changing current char (only once)
        if (canChange) {
            for (int i = 0; i < 26; i++) {
                int newChars = uniqueChars | (1 << i);
                int newCt = Integer.bitCount(newChars);

                if (newCt > k)
                    result = Math.max(result, 1 + findPartitions(idx + 1, (1 << i), k, arr, false));
                else
                    result = Math.max(result, findPartitions(idx + 1, newChars, k, arr, false));
            }
        }

        map.put(key, result);
        return result;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        char[] arr = s.toCharArray();
        map.clear();
        return findPartitions(0, 0, k, arr, true) + 1;
    }

}




// import java.util.*;

// class Solution {

//     // DP-style version of findPartitions
//     public int findPartitionsDP(char[] arr, int k) {
//         int n = arr.length;
//         int[] dp = new int[n]; // dp[i] = partitions till i
//         Set<Character> distinct = new HashSet<>();

//         dp[0] = 1;
//         distinct.add(arr[0]);

//         for (int i = 1; i < n; i++) {
//             char ch = arr[i];

//             // Same logic: if we already have k distinct chars and this is a new one, start new partition
//             if (distinct.size() == k && !distinct.contains(ch)) {
//                 dp[i] = dp[i - 1] + 1;
//                 distinct.clear(); // reset distinct set for new partition
//             } else {
//                 dp[i] = dp[i - 1];
//             }

//             distinct.add(ch);
//         }

//         return dp[n - 1];
//     }

//     public int maxPartitionsAfterOperations(String s, int k) {
//         int n = s.length();
//         int ans = 0;
//         char[] arr = s.toCharArray();

//         for (int i = 0; i < n; i++) {
//             char original = arr[i];

//             for (char ch = 'a'; ch <= 'z'; ch++) {
//                 if (ch == original) continue;

//                 arr[i] = ch;
//                 int partitions = findPartitionsDP(arr, k);
//                 ans = Math.max(ans, partitions);
//             }

//             arr[i] = original; // restore
//         }

//         return ans;
//     }
// }