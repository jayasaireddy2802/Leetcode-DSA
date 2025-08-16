// class Solution {
//     public int maximum69Number (int num) {
//         char[] arr = Integer.toString(num).toCharArray();
//         int len = arr.length;
//         for(int i = 0; i < len; i++)
//         {
//             if(arr[i] == '6')
//             {
//                 arr[i] = '9';
//                 break;
//             }
//         }
//         return Integer.parseInt(new String(arr));
//     }
// }


class Solution {
    public int maximum69Number (int num) {
        int place = -1, temp = num, ct = 0;
        
        while(temp > 0)
        {
            if(temp % 10 == 6)
            {
                place = ct;
            }
            temp /= 10;
            ct++;
        }

        return (place == -1) ? num : num + 3 * (int)Math.pow(10, place);
    }
}