class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1;
        int j = len2 - 1;
        int carry = 0;

        while(i >= 0 && j >= 0)
        {
            int sum = carry + (a.charAt(i) == '1' ? 1 : 0) + (b.charAt(j) == '1' ? 1 : 0);
            if(sum == 0)
            {
                sb.append('0');
                carry = 0;
            }
            else if(sum == 1)
            {
                sb.append('1');
                carry = 0;
            }
            else if(sum == 2)
            {
                sb.append('0');
                carry = 1;
            }
            else
            {
                sb.append('1');
                carry = 1;
            }
            i--;
            j--;
        }

        while(i >= 0)
        {
            int sum = (a.charAt(i) == '1' ? 1 : 0) + carry;
            if(sum == 0)
            {
                sb.append('0');
                carry = 0;
            }
            else if(sum == 1)
            {
                sb.append('1');
                carry = 0;
            }
            else
            {
                sb.append('0');
                carry = 1;
            }
            i--;
        }
        
        while(j >= 0)
        {
            int sum = (b.charAt(j) == '1' ? 1 : 0) + carry;
            if(sum == 0)
            {
                sb.append('0');
                carry = 0;
            }
            else if(sum == 1)
            {
                sb.append('1');
                carry = 0;
            }
            else
            {
                sb.append('0');
                carry = 1;
            }
            j--;
        }
        if(carry == 1)
            sb.append('1');
        return sb.reverse().toString();
    }
}