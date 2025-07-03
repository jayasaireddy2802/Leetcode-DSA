class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        int idx = k;

        while(sb.length() < k)
        {
            int len = sb.length();
            int i = 0;
            while(i < len)
            {
                // char next = (char)(((sb.charAt(i) - 'a' + 1) % 26) + 'a');
                // sb.append(next);

                sb.append((char)((((sb.charAt(i) - 'a') + 1) % 26) + 'a'));
                i++;
            }
        }

        return sb.charAt(idx-1);
    }
}