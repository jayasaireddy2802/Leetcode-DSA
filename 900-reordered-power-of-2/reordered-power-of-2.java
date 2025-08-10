class Solution {

    public boolean powerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public boolean solve(int idx, StringBuilder sb) {
        int len = sb.length();

        // If we've placed all characters, check the number
        if (idx == len) {
            if (sb.charAt(0) == '0') return false; // avoid leading zeros
            int n = Integer.parseInt(sb.toString());
            return powerOfTwo(n);
        }

        for (int i = idx; i < len; i++) {
            // swap idx and i
            char temp = sb.charAt(idx);
            sb.setCharAt(idx, sb.charAt(i));
            sb.setCharAt(i, temp);

            if (solve(idx + 1, sb)) {
                return true;
            }

            // swap back
            temp = sb.charAt(idx);
            sb.setCharAt(idx, sb.charAt(i));
            sb.setCharAt(i, temp);
        }
        return false;
    }

    public boolean reorderedPowerOf2(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        return solve(0, sb);
    }
}
