class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = nums.length;
        int ans = 0;

        while(j < len)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.getOrDefault(nums[j], 0) > k)
            {
                int val = map.getOrDefault(nums[i], -1);
                // if(val == -1)
                //     break;
                map.put(nums[i], val - 1);
                i++;
            }
            ans = Math.max(ans, (j - i + 1));
            j++;
        }

        return ans;

    }
}