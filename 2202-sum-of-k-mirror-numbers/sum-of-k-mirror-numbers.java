// class Solution {

//     public boolean palindrome(String str) {
//         int len = str.length();
//         int i = 0;
//         while (i < len / 2) {
//             if (str.charAt(i) != str.charAt(len - i - 1))
//                 return false;
//             i++;
//         }
//         return true;
//     }

//     public long kMirror(int k, int n) {
//         int len = 100000000;
//         int ct = 0;
//         long ans = 0;

//         for (int i = 1; i < len; i++) {
//             if (palindrome(Integer.toString(i))) {
//                 if (palindrome(Integer.toString(i, k))) {
//                     ct++;
//                     ans += i;
//                 }
//             }
//             if (ct == n)
//                 break;
//         }

//         return ans;
//     }
// }


class Solution {

    public boolean isPalindrome(String str)
    {

        int len = str.length();
        int i = 0;
        while(i < len / 2)
        {
            if(str.charAt(i) != str.charAt(len - i - 1))
                return false;
            i++;
        }

        return true;
    }

    public List<Long> generatePalindromes(int length)
    {
        int half_length = (length + 1) / 2;
        List<Long> list = new ArrayList<>();
        long start = (long) Math.pow(10, half_length - 1);
        long end = (long) Math.pow(10, half_length);

        for(long i = start; i < end; i++)
        {
            String halfString = Long.toString(i);
            int j = length / 2;
            j--;
            while(j >= 0)
            {
                halfString = halfString + halfString.charAt(j);
                j--;
            }
            list.add(Long.parseLong(halfString));
        }

        return list;
    }

    public long kMirror(int k, int n) {

        int len = 50;
        int ct = 0;
        long ans = 0;

        for(int i = 1;  i < len; i++)
        {
            List<Long> list = generatePalindromes(i);
            for(long num : list)
            {
                if(isPalindrome(Long.toString(num, k)))
                {
                    ct++;
                    ans += num;
                }
                if(ct == n)
                    return ans;
            }
        }

        return ans;
    }
}
