class Solution {


private long combinationLimited(int n, int r, int limit) {
    r = Math.min(r, n - r);
    long value = 1;

    for (int i = 1; i <= r; i++) {
        value = value * (n - r + i) / i;
        if (value >= limit) {
            return limit;
        }
    }
    return value;
}

public String smallestPalindrome(String s, int k) {
    int length = s.length();

    char middleChar = 0;
    if (length % 2 == 1) {
        middleChar = s.charAt(length / 2);
    }

    int[] freq = new int[26];

    for (int i = 0; i < length; i++) {
        if (length % 2 == 1 && i == length / 2) continue;
        freq[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
        freq[i] /= 2;
    }

    StringBuilder firstHalf = new StringBuilder();
    int halfSize = length / 2;

    for (int pos = 0; pos < halfSize; pos++) {
        boolean found = false;

        for (int ch = 0; ch < 26; ch++) {
            if (freq[ch] == 0) continue;

            freq[ch]--;

            long ways = 1;
            int remaining = 0;

            for (int f : freq) {
                remaining += f;
            }

            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    ways *= combinationLimited(remaining, freq[i], k);
                    remaining -= freq[i];
                }
                if (ways >= k) break;
            }

            if (ways >= k) {
                firstHalf.append((char) (ch + 'a'));
                found = true;
                break;
            }

            k -= ways;
            freq[ch]++;
        }

        if (!found) return "";
    }

    StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

    if (middleChar != 0) {
        firstHalf.append(middleChar);
    }

    return firstHalf.toString() + secondHalf.toString();
}

}
