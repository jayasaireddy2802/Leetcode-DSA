// class Solution {
//     public boolean isDominent( int i, int j, String s)
//     {
//         int ct0 = 0;
//         int ct1 = 0;

//         for(int k = i; k <= j; k++)
//         {
//             if(s.charAt(k) == '1')
//                 ct1++;
//             else
//                 ct0++;
//         }

//         return (ct1 >= ct0 * ct0);
//     }
//     public int numberOfSubstrings(String s) {
        
//         int len = s.length();   
//         int ct = 0;

//         for(int i = 0; i < len; i++)
//         {
//             for(int j = i; j < len; j++)
//             {
//                 if(isDominent(i, j, s))
//                     ct++;
//             }
//         }

//         return ct;
//     }
// }


class Solution {
    public int numberOfSubstrings(String s) {

        int length = s.length();
        int[] prefixOnes = new int[length];

        // Build prefix sum of ones
        prefixOnes[0] = (s.charAt(0) == '1') ? 1 : 0;
        for (int i = 1; i < length; i++) {
            prefixOnes[i] = prefixOnes[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int totalSubstrings = 0;

        for (int start = 0; start < length; start++) {

            for (int end = start; end < length; end++) {

                int ones = prefixOnes[end] - (start > 0 ? prefixOnes[start - 1] : 0);
                int zeros = (end - start + 1) - ones;

                int zeroSquared = zeros * zeros;

                if (zeroSquared > ones) {
                    // Skip unnecessary end indices
                    int skip = zeroSquared - ones;
                    end += skip - 1;

                } else if (zeroSquared == ones) {
                    totalSubstrings++;

                } else { // zeroSquared < ones
                    totalSubstrings++;

                    int adjust = (int) Math.sqrt(ones) - zeros;
                    int nextEnd = end + adjust;

                    if (nextEnd >= length) {
                        totalSubstrings += (length - end - 1);
                        break;
                    } else {
                        totalSubstrings += adjust;
                    }

                    end = nextEnd;
                }
            }
        }

        return totalSubstrings;
    }
}
// 