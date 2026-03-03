class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");

        for(int i = 1; i < n; i++)
        {
            StringBuilder sb1 = new StringBuilder();
            for(int j = 0; j < sb.length(); j++)
            {
                sb1.append(sb.charAt(j) == '1' ? '0' : '1');
            }
            sb = sb.append('1').append(sb1.reverse());
        }

        return sb.charAt(k-1);
    }
}