class Solution {
    public long countGood(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int i = 0;
        int j = 0;
        long ct = 0; // use long to avoid overflow for large inputs
        long ans = 0;

        while (j < len) {
            // Add nums[j] to the map
            int count = map.getOrDefault(nums[j], 0);
            ct += count; // each existing count forms 'count' new pairs with nums[j]
            map.put(nums[j], count + 1);

            // While we have enough pairs, move the left pointer
            while (ct >= k) {
                ans += (len - j); // all subarrays from i to j...len-1 are valid

                // Remove nums[i] from the window
                int freq = map.get(nums[i]);
                ct -= (freq - 1); // removing one occurrence removes (freq - 1) pairs
                map.put(nums[i], freq - 1);
                i++;
            }

            j++;
        }

        return ans;
    }
}
