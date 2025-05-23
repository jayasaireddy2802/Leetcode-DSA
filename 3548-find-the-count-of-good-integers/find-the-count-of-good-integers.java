// import java.util.*;

// class Solution {
//     public long countGoodIntegers(int n, int k) {
//         Set<String> st = new HashSet<>();

//         int d = (n + 1) / 2;
//         int start = (int) Math.pow(10, d - 1);
//         int end = (int) Math.pow(10, d) - 1;

//         for (int num = start; num <= end; num++) {
//             String leftHalf = Integer.toString(num);
//             String full;

//             if (n % 2 == 0) {
//                 full = leftHalf + new StringBuilder(leftHalf).reverse().toString();
//             } else {
//                 full = leftHalf + new StringBuilder(leftHalf.substring(0, d - 1)).reverse().toString();
//             }

//             long number = Long.parseLong(full);
//             if (number % k != 0) continue;

//             char[] chars = full.toCharArray();
//             Arrays.sort(chars);
//             st.add(new String(chars));
//         }

//         long[] factorial = new long[11];
//         factorial[0] = 1;
//         for (int i = 1; i < 11; i++) {
//             factorial[i] = factorial[i - 1] * i;
//         }

//         long result = 0;

//         for (String s : st) {
//             int[] count = new int[10];
//             for (char ch : s.toCharArray()) {
//                 count[ch - '0']++;
//             }

//             int totalDigits = s.length();
//             int zeroDigits = count[0];
//             int nonZeroDigits = totalDigits - zeroDigits;

//             long perm = nonZeroDigits * factorial[totalDigits - 1];
//             for (int i = 0; i < 10; i++) {
//                 perm /= factorial[count[i]];
//             }

//             result += perm;
//         }

//         return result;
//     }
// }


class Solution {

    long[] fact = new long[11];
    
    public void fact()
    {
        fact[0] = 1;
        for(int i = 1; i < 11; i++)
            fact[i] = fact[i-1] * i;
    }

    public long totalPermutations(Set<String> set, int k)
    {
        long total = 0;
        for(String num : set)
        {           
            int len = num.length();
            int[] freq = new int[10];
            for(char ch : num.toCharArray())
            {
                freq[ch - '0']++;
            }

            int zeroes = freq[0];
            int nonzerodigits = len - zeroes;

            long perm = nonzerodigits * fact[len - 1];

            for(int i = 0; i < 10; i++)
            {
               perm = perm / fact[freq[i]];
            }

            total += perm;
        }

        return total;
    }
    public long countGoodIntegers(int n, int k) {
        fact();
        Set<String> set = new HashSet<>();

        int digits = (n+1)/2;
        boolean odd = (n % 2 == 0) ? false : true;
        long start = (long)Math.pow(10, digits - 1);
        long end = (long)Math.pow(10, digits) - 1;

        for(long i = start; i <= end; i++)
        {
            String str = Long.toString(i);
            StringBuilder sb = new StringBuilder(str);
            if(odd)
            {
                sb = sb.append(new StringBuilder(str.substring(0, digits - 1)).reverse());
            }
            else
                sb = sb.append(new StringBuilder(str).reverse());

            str = sb.toString();
            if(Long.parseLong(str) % k != 0)
                continue;

            char[] arr = str.toCharArray();
            Arrays.sort(arr);   
            String s = new String(arr);         
            set.add(s);
        }

        return totalPermutations(set, k);
    }
}