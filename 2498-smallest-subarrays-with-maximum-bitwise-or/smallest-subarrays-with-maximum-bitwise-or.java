class Solution {

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] lastSeenBitIndex = new int[31];
        Arrays.fill(lastSeenBitIndex, -1);
        int[] result = new int[n];

        for (int index = n - 1; index >= 0; --index) {
            int farthestReach = index;

            for (int bit = 0; bit < 31; ++bit) {
                if ((nums[index] & (1 << bit)) == 0) {
                    if (lastSeenBitIndex[bit] != -1) {
                        farthestReach = Math.max(farthestReach, lastSeenBitIndex[bit]);
                    }
                } else {
                    lastSeenBitIndex[bit] = index;
                }
            }

            result[index] = farthestReach - index + 1;
        }

        return result;
    }
}
