// i < j < k
// abs(i - j) + abs(j - k) + abs(k - i) = (j - i) + (k - j) + (k - i) 
//                                      = 2k - 2i = 2*(k-i)


class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++)
        {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(int key : map.keySet())
        {
            List<Integer> list = map.get(key);
            int size = list.size();

            for(int i = 0; i < size - 2; i++)
            {
                int val1 = list.get(i);
                int val2 = list.get(i + 2);

                mini = Math.min(mini, 2*(val2 - val1));
            }
        }

        return (mini == Integer.MAX_VALUE) ? -1 : mini;
    }
}