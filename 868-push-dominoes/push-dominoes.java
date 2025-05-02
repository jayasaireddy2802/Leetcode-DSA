class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] left = new int[len];
        int[] right = new int[len];
        int force = 0;

        // From left to right: force of R
        for (int i = 0; i < len; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = len;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            right[i] = force;
        }

        // From right to left: force of L
        for (int i = len - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = len;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            left[i] = force;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (left[i] == right[i])
                result.append('.');
            else if (left[i] > right[i])
                result.append('L');
            else
                result.append('R');
        }

        return result.toString();
    }
}
