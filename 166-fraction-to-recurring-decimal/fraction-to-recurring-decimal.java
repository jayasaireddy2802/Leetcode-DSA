class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(denominator == 0 || numerator == 0)
            return "0";

        if((numerator < 0) ^ (denominator < 0))
            sb.append('-');

        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);

        long q = n / d;
        long r = n % d;
        int idx = -1;
        Map<Long, Integer> map = new HashMap<>();

        sb.append(q);
        if(r == 0)
            return sb.toString();
        else
        {
            sb.append('.');
            idx = sb.length();
            while(r != 0)
            {
                
                if (map.containsKey(r)) {
                sb.insert(map.get(r), "(");
                sb.append(")");
                return sb.toString();
            }

            map.put(r, sb.length());
            r *= 10;
            sb.append(r / d);
            r %= d;
            }

        }

        return sb.toString();
    }
}