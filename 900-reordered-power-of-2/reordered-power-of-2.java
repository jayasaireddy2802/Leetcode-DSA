// class Solution {

//     public boolean powerOfTwo(int n) {
//         return (n & (n - 1)) == 0;
//     }

//     public boolean solve(int idx, StringBuilder sb) {
//         int len = sb.length();

//         // If we've placed all characters, check the number
//         if (idx == len) {
//             if (sb.charAt(0) == '0') return false; // avoid leading zeros
//             int n = Integer.parseInt(sb.toString());
//             return powerOfTwo(n);
//         }

//         for (int i = idx; i < len; i++) {
//             // swap idx and i
//             char temp = sb.charAt(idx);
//             sb.setCharAt(idx, sb.charAt(i));
//             sb.setCharAt(i, temp);

//             if (solve(idx + 1, sb)) {
//                 return true;
//             }

//             // swap back
//             temp = sb.charAt(idx);
//             sb.setCharAt(idx, sb.charAt(i));
//             sb.setCharAt(i, temp);
//         }
//         return false;
//     }

//     public boolean reorderedPowerOf2(int n) {
//         StringBuilder sb = new StringBuilder(Integer.toString(n));
//         return solve(0, sb);
//     }
// }

// class Solution{
//     public String sort(int n)
//     {
//         char[] arr = Integer.toString(n).toCharArray();
//         Arrays.sort(arr);
//         return new String(arr);
//     }
//     public boolean reorderedPowerOf2(int n) {
        
//         String str = sort(n);

//         int num = 0;
//         int i = 0;
//         while(i < 31)
//         {
//             num = (1 << i);
//             if(str.equals(sort(num)))
//                 return true;
//             i++;
//         }

//         return false;
//     }
// }



class Solution {

    public boolean powerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public boolean solve(int idx, char[] arr) {
        int len = arr.length;

        // If we've placed all characters, check the number
        if (idx == len) {
            if (arr[0] == '0') return false; // avoid leading zeros
            int n = Integer.parseInt(new String(arr));
            return powerOfTwo(n);
        }

        for (int i = idx; i < len; i++) {
            // swap idx and i
            char temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;

            if (solve(idx + 1, arr)) {
                return true;
            }

            // swap back
            temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
        
        return false;
    }

    public boolean reorderedPowerOf2(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        return solve(0, arr);
    }
}
