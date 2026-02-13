class Solution {

    static class DiffPair {
        int diffAB, diffAC;

        DiffPair(int diffAB, int diffAC) {
            this.diffAB = diffAB;
            this.diffAC = diffAC;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof DiffPair)) return false;
            DiffPair other = (DiffPair) obj;
            return diffAB == other.diffAB && diffAC == other.diffAC;
        }

        @Override
        public int hashCode() {
            return 31 * diffAB + diffAC;
        }
    }

    public int longestBalanced(String input) {

        char[] chars = input.toCharArray();
        int length = chars.length;

        int maxResult = 0;

        // Case 1: Longest block of identical characters
        int currentCount = 1;

        for (int i = 1; i < length; i++) {
            if (chars[i] == chars[i - 1]) {
                currentCount++;
            } else {
                maxResult = Math.max(maxResult, currentCount);
                currentCount = 1;
            }
        }
        maxResult = Math.max(maxResult, currentCount);

        // Case 2: Balanced between two characters
        maxResult = Math.max(maxResult, findBalancedTwo(chars, 'a', 'b'));
        maxResult = Math.max(maxResult, findBalancedTwo(chars, 'a', 'c'));
        maxResult = Math.max(maxResult, findBalancedTwo(chars, 'b', 'c'));

        // Case 3: Balanced among three characters
        int countA = 0, countB = 0, countC = 0;

        Map<DiffPair, Integer> firstOccurrence = new HashMap<>();

        for (int i = 0; i < length; i++) {

            if (chars[i] == 'a') countA++;
            else if (chars[i] == 'b') countB++;
            else countC++;

            if (countA == countB && countA == countC) {
                maxResult = Math.max(maxResult, countA + countB + countC);
            }

            DiffPair key = new DiffPair(countA - countB, countA - countC);

            Integer prevIndex = firstOccurrence.get(key);
            if (prevIndex != null) {
                maxResult = Math.max(maxResult, i - prevIndex);
            } else {
                firstOccurrence.put(key, i);
            }
        }

        return maxResult;
    }

    private int findBalancedTwo(char[] chars, char firstChar, char secondChar) {

        int length = chars.length;
        int maxLength = 0;

        int[] firstSeen = new int[2 * length + 1];
        Arrays.fill(firstSeen, -2);

        int resetIndex = -1;
        int balance = length;

        firstSeen[balance] = -1;

        for (int i = 0; i < length; i++) {

            if (chars[i] != firstChar && chars[i] != secondChar) {

                resetIndex = i;
                balance = length;
                firstSeen[balance] = resetIndex;

            } else {

                if (chars[i] == firstChar) balance++;
                else balance--;

                if (firstSeen[balance] < resetIndex) {
                    firstSeen[balance] = i;
                } else {
                    maxLength = Math.max(maxLength, i - firstSeen[balance]);
                }
            }
        }

        return maxLength;
    }
}
