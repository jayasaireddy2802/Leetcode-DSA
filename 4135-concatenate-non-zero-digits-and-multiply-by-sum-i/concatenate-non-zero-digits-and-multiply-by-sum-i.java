class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;

        while(n > 0)
        {
            int rem = n % 10;
            sum += rem;
            if(rem != 0) sb.append((char)(rem + '0'));
            n /= 10;
        }

        if (sb.length() == 0) return 0;

        sb.reverse();

        return sum * (Integer.parseInt(sb.toString()));
    }
}