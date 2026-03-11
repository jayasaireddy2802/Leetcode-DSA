// class Solution {
//     public int bitwiseComplement(int n) {
//         String binaryString = Integer.toString(n, 2);
//         StringBuilder sb = new StringBuilder();
//         int len = binaryString.length();

//         for(int i = 0; i < len; i++)
//         {
//             sb.append(binaryString.charAt(i) == '0' ? '1' : '0');
//         }

//         return Integer.parseInt(sb.toString(), 2);
//     }
// }


class Solution {
    public int bitwiseComplement(int n) {
        String binaryString = Integer.toString(n, 2);
        int len = binaryString.length() - 1;
        int num = 0;

        for(int i = len; i >= 0; i--)
        {
            if(binaryString.charAt(i) == '0')
            {
                num = num | (1 << len - i);
            }
        }

        return num;
    }
}